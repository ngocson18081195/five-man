package fm.product.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;

/**
 * Create by ngocson on 27/03/2019
 */
@RestController
@RequestMapping(value = "/product")
public class ProductControl {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/list")
    public ResponseEntity getProducts() {
        ResponseEntity<Object> exchange = restTemplate.exchange("http://localhost:5000/test/list",
                HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {
                });

        return ResponseEntity.ok(exchange.getBody());
    }
}
