package app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mtimotijevic on 20.2.18..
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findOneByName(String name);
}
