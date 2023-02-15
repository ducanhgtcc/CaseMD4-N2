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
    public class ProductService{

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

        public List<Product> showProductByCategoryName(String name) {
            return productRepo.findProductByCategory_Name(name);
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

        public List<Product> showByStatus(String status) {

            List<Product> newlist = new ArrayList<>();

            for (int i = 0; i < findAll().size(); i++) {
                if (findAll().get(i).getStatus().equals(status)) {
                    newlist.add(findAll().get(i));
                }
            }
            return newlist;
        }

    }
