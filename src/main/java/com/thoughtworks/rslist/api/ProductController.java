package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@ControllerAdvice
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/addList")
    public ResponseEntity add(@RequestBody List<Product> products) {
        productService.saveAll(products);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<ProductEntity>> list() {
        return ResponseEntity.ok(productService.findList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
