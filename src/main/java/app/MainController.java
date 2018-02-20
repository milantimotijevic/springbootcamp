package app;

import app.security.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public List<Product> getAllProducts(HttpServletRequest req) {
        Authentication auth = TokenAuthenticationService.getAuthentication(req);
        String info = auth.getName();
        System.out.println(info);
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
