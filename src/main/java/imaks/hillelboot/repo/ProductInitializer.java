package imaks.hillelboot.repo;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ProductInitializer {

    private final ProductRepo productRepo;

    @PostConstruct
    @Transactional
    public void initProducts() {
        if (productRepo.count() == 0) {
            productRepo.insertProducts();
        }
    }
}
