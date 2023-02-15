package com.casemodul4_backend.repository;
import com.casemodul4_backend.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
}
