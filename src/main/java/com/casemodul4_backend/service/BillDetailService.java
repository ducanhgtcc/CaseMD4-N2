package com.casemodul4_backend.service;

import com.casemodul4_backend.model.BillDetail;
import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.model.Product;
import com.casemodul4_backend.repository.BillDetailRepo;
import com.casemodul4_backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillDetailService implements InterfaceGeneral<BillDetail> {
    @Autowired
    BillDetailRepo billDetailRepo;


    @Override
    public List<BillDetail> findAll() {
        return (List<BillDetail>) billDetailRepo.findAll();
    }

    @Override
    public Optional<BillDetail> findById(int id) {
        return billDetailRepo.findById(id);
    }

    @Override
    public void save(BillDetail billDetail) {
        billDetailRepo.save(billDetail);
    }

    @Override
    public void delete(int id) {
        billDetailRepo.deleteById(id);

    }
    public  List<BillDetail> findByIdAccount(int idAccount){
        List<BillDetail> newlist = new ArrayList<>();

        for (int i=0; i< findAll().size();i++){
            if (findAll().get(i).getBill().getAccount().getId()==idAccount){
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }
    public  List<BillDetail> findByIdBill(int idBill){
        List<BillDetail> newlist = new ArrayList<>();

        for (int i=0; i< findAll().size();i++){
            if (findAll().get(i).getBill().getId()==idBill){
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }
    public  long getSumBillById(int id){
        long sum = 0;
        for (int i=0; i< findByIdBill(id).size();i++){
                sum+=findByIdBill(id).get(i).getProduct().getPrice();

        }
        return sum;
    }
}
