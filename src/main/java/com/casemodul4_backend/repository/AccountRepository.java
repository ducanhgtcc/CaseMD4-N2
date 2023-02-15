package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
      List<Account> findAllById(Integer id);
//    Account findById(Integer id);
}