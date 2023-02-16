package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;


    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }


    public Product findById(int id) {
        return productRepo.findById(id).get();
    }


    public void save(Product product) {
        productRepo.save(product);

    }


    public Product setStatus(int id) {
        Product product = findById(id);
        productRepo.findById(id).get().setStatus("hết");
        return product;
    }

    public List<Product> findAllByNameLike(String name) {
        return productRepo.findByNameLike(name);
    }

    public Product checkDuplicateName(String name) {
        return productRepo.checkDuplicateName(name);
    }

    public List<Product> showProductByCategory_Id(int id) {
        return productRepo.findProductByCategory_Id(id);
    }
}
