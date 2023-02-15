package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements InterfaceGeneral<Product>{
    @Autowired
    ProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);

    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);

    }

}
