package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements InterfaceGeneral<Product> {
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

    public List<Product> showByStatus1() {
        List<Product> newList = new ArrayList<>();
        System.out.println(productRepo.findAll());
        for (Product c : productRepo.findAll()) {
            if (c.getStatus().equals("con")) {
                newList.add(c);
            }
        }
        return newList;
    }
    public  List<Product> showByStatus(String status) {

        List<Product> newlist = new ArrayList<>();

        for (int i=0; i< findAll().size();i++){
            if (findAll().get(i).getStatus().equals(status)){
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }

}
