package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Img;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImgRepo extends PagingAndSortingRepository<Img, Integer> {

//    @Query(nativeQuery = true, value
//            = "SELECT * FROM  (SELECT i.id, i.img, p.name FROM img AS i JOIN product AS p on i.product_id = p.id) as T  " +
//            "WHERE T.name  like concat ('%',:name,'%');")
//    List<Img> findImgByNameProduct(@Param("name") String name);


    List<Img> findImgByProduct_Id(int id);
}
