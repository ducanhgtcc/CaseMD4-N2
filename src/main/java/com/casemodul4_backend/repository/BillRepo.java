package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends PagingAndSortingRepository<Bill,Integer> {
}
