package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Account;
import com.casemodul4_backend.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    AccountRepo accountRepo;


    public List<Account> findAll() {
        return (List<Account>) accountRepo.findAll();
    }


    public Optional<Account> findById(int id) {
        return accountRepo.findById(id);
    }


    public void save(Account account) {
        accountRepo.save(account);

    }


    public void delete(int id) {
        accountRepo.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUsername(username);
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }

    public Account findAccountByUsername(String username) {
        return accountRepo.findAccountByUsername(username);
    }
    public Account checkDuplicateUserName(String username){
        return accountRepo.checkDuplicateUserName(username);
    }
}
