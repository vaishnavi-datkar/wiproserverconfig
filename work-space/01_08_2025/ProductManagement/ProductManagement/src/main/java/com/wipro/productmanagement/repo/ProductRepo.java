package com.wipro.productmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productmanagement.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
