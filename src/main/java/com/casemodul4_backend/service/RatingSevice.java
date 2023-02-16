package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Rating;
import com.casemodul4_backend.repository.AccountRepository;
import com.casemodul4_backend.repository.ProductRepo;
import com.casemodul4_backend.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingSevice {
    @Autowired
    RatingRepo ratingRepo;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    AccountRepository accountRepository;


    public Iterable<Rating> findAll() {
        return (ratingRepo.findAll());
    }


    public Iterable<Object> findById(int id) {
        return ratingRepo.findById(id);
    }


    public void save(Rating rating) {
        ratingRepo.save(rating);
    }


    public void delete(int id) {
    }

    public List<Rating> findByIdProduct(int id) {
        return   ratingRepo.findAllByProduct(productRepo.findById(id).get());

    }
    public float  getAvgPoints(int id) {
        float avgPoints = 0.0F;
        for (int i = 0; i < findByIdProduct(id).size(); i++) {
            avgPoints+=findByIdProduct(id).get(i).getPoint();
        }
        avgPoints= avgPoints/findByIdProduct(id).size();
        return avgPoints;
    }

}
