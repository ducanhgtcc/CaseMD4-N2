package com.casemodul4_backend.repository;
import com.casemodul4_backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "select * from product where name=:name ")
    Product checkDuplicateName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT * from product where name like concat('%',:name,'%');")
    List<Product> findByNameLike(@Param("name") String name);
}
