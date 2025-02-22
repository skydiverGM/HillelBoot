//package imaks.hillelmvc.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//public class OrderProduct {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    private int quantity;
//    private double price;
//}
