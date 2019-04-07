package fmdatabase.controller;

import fm.entity.product.Product;
import fmdatabase.repository.ProductRepository;
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
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/list")
    public ResponseEntity getList() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}
