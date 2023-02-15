package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Bill;
import com.casemodul4_backend.repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BillService implements InterfaceGeneral<Bill> {
    @Autowired
    BillRepo billRepo;

    public BillService() {
    }

    @Override
    public List<Bill> findAll() {
        return (List<Bill>) billRepo.findAll();
    }

    @Override
    public Optional<Bill> findById(int id) {
        return Optional.of(billRepo.findById(id).get());
    }

    @Override
    public void save(Bill bill) {
        billRepo.save(bill);
    }

    @Override
    public void delete(int id) {
        billRepo.deleteById(id);
    }

    public List<Bill> findByIdAccount(int idAccount) {
        List<Bill> newlist = new ArrayList<>();

        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getAccount().getId() == idAccount) {
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }
    public List<Integer> findJustById(List<Bill> list) {
        List<Integer> newlist = new ArrayList<>();

        for (int i = 0; i < findAll().size(); i++) {
                newlist.add(findAll().get(i).getId());
        }
        return newlist;
    }
    public int findNewBill(){
      return   Collections.max(findJustById(findAll()));
    }
}