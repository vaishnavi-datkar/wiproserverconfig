package com.wipro.productmanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.productmanagement.entity.Product;


public interface ProductService {
	void save(Product product);
 List<Product> findAll();
 Product findById(int id);
 void deleteById(int id);
 Page<Product> findAll(Pageable p);

	
}