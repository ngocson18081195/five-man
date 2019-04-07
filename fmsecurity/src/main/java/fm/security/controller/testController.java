package fm.security.controller;

import fm.entity.product.Product;
import fm.security.repository.testrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by ngocson on 06/04/2019
 */
@RestController
@RequestMapping(value = "/test")
public class testController {

    @Autowired
    private testrepository testrepository;

    @GetMapping("/list")
    private ResponseEntity getList() {
        List<Product> productList = (List<Product>) testrepository.findAll();
        return ResponseEntity.ok(productList);
    }
}
