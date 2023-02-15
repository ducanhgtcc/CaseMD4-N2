package com.casemodul4_backend.repository;

import com.casemodul4_backend.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends PagingAndSortingRepository<Account, Integer> {
    Account findAccountByUsername(String username);

    @Query(nativeQuery = true, value = "select * from account where username=:username")
    Account checkDuplicateUserName(@Param("username") String username);


}
