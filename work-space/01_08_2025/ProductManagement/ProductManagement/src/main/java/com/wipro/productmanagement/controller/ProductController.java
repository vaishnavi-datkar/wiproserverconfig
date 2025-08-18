package com.wipro.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.productmanagement.entity.Product;
import com.wipro.productmanagement.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {

    
    @Autowired
     ProductService productService;

    
    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    
    @PutMapping
    public void update(@RequestBody Product product){
        productService.save(product);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteById(id);
    }
    @GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
    public Page<Product> findAllPage(@PathVariable int  pageNum,@PathVariable int  pageSize,@PathVariable int  sortOrder) {
    	Pageable p=null;
    	if(sortOrder==0)
  	  {
  		  p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").descending());
  	  }
  	  else
  	  {
  		    p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").ascending());
  	  }

        
        return productService.findAll(p);
    }
}
