package imaks.hillelboot.controller;

import imaks.hillelboot.entity.Order;
import imaks.hillelboot.exception.OrderNotFoundException;
import imaks.hillelboot.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Order order) {
        Long orderId = orderRepo.save(order).getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(orderId)
                .toUri();

        return ResponseEntity.created(location).body(orderId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderRepo.findAll());
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order updatedOrder) {
        Order order = orderRepo.findById(updatedOrder.getId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        order.setTotalCost(updatedOrder.getTotalCost());
        order.setProducts(updatedOrder.getProducts());

        return ResponseEntity.ok(orderRepo.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        orderRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
