package com.shopflow.order_service.client;

import com.shopflow.order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8082/api/products")
public interface ProductClient {

    //Get Request for getting product details by id
    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);



}
