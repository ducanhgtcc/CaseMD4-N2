package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.model.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RatingRepo extends PagingAndSortingRepository<Rating,Integer> {

    List<Object> findById(int id);
    List<Rating> findAllByProduct(Product product);
}
