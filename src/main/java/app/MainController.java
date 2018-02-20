package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mtimotijevic on 18.2.18..
 */
@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/")
    public String getTest() {
        return "Test successful";
    }

    @RequestMapping(value="/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value="/product", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(value="/product/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productRepository.findOneByName(name);
    }

}
