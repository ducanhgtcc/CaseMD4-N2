package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CmtRepo  extends PagingAndSortingRepository<Comment, Integer> {
    List<Comment> findAllById(Integer id);

}
