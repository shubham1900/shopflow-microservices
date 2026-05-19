package com.shopflow.product_service.service;

import com.shopflow.product_service.model.Product;
import com.shopflow.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public  List<Product> findAllByName(String name){
        return productRepository.findByName(name);
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public  void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
