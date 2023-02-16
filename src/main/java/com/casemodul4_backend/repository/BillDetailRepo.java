package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.BillDetail;
import com.casemodul4_backend.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BillDetailRepo extends PagingAndSortingRepository<BillDetail,Integer> {
//  List<Product> findAllByProduct_Id
}
