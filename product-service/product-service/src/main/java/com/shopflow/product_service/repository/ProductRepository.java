package com.shopflow.product_service.repository;


import com.shopflow.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByName(String name);
}
