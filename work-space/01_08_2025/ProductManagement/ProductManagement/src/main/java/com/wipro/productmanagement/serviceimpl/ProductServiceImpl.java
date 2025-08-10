package com.wipro.productmanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.productmanagement.entity.Product;
import com.wipro.productmanagement.repo.ProductRepo;
import com.wipro.productmanagement.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

    
    @Autowired
    private ProductRepo productRepo;

    @Override
    public void save(Product product) {
        
        productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product=productRepo.findById(id);
        if(!product.isEmpty()) {
        	return product.get();
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        
        productRepo.deleteById(id);
    }

    
    public Page<Product> findAll(Pageable p){
        return productRepo.findAll(p);
    }
}
