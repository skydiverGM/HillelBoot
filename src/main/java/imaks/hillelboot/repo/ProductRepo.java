package imaks.hillelboot.repo;

import imaks.hillelboot.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
                    INSERT INTO products (name, price) VALUES
                            ('Laptop', 1200.50),
                            ('Mouse', 25.99),
                            ('Smartphone', 499.99),
                            ('Headphones', 49.99),
                            ('USB Cable', 9.99),
                            ('Power Bank', 14.49),
                            ('Keyboard', 55.00),
                            ('Monitor', 199.99),
                            ('Webcam', 89.99),
                            ('External HDD', 79.99)
            """, nativeQuery = true)
    void insertProducts();
}
