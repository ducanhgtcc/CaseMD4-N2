package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends PagingAndSortingRepository<Category,Integer> {
}
