package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Category;
import com.casemodul4_backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends PagingAndSortingRepository<Category,Integer> {
    @Query(nativeQuery = true, value = "select * from category where name=:name ")
    Category checkDuplicateName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT * from category where name like concat('%',:name,'%');")
    List<Category> findByNameLike(@Param("name") String name);
}
