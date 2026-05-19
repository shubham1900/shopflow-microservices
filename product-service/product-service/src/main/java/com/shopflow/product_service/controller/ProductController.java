package com.shopflow.product_service.controller;

import com.shopflow.product_service.model.Product;
import com.shopflow.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/searchByName")
    public ResponseEntity getProductByName(@RequestParam String name){
        return new ResponseEntity<>(productService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);


        }
        @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody Product product) {
            return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
        }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
