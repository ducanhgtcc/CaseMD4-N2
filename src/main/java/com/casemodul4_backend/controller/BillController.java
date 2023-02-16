package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.Bill;
import com.casemodul4_backend.service.BillService;
import com.casemodul4_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/bills")
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    ProductService productService;

    //Hiển thị tất cả ảnh
    @GetMapping
    public List<Bill> showAllBill() {
        return billService.findAll();
    }

    //    Thêm bill
    @PostMapping
    public void create(@RequestBody Bill bill) {
        billService.save(bill);
    }

    //    Hiển thị bill
    @GetMapping("/{id}")
    public Bill showEdit(@PathVariable int id) {
        return billService.findById(id).get();
    }

    //    Sửa bill
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody Bill bill) {
        billService.save(bill);

    }

    //    Xóa bill
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        billService.delete(id);
    }

    @GetMapping("/getBillById/{id}")
    public Optional<Bill> getBillById(@PathVariable int id) {
        return billService.findById(id);
    }

    @GetMapping("/getBillByAccountId/{id}")
    public List<Bill> findByIdAccount(@PathVariable int id) {
        return billService.findByIdAccount(id);
    }

    //
    @GetMapping("/getNewBill")
    public int getNewBill() {
        return billService.findNewBill()+1;
    }


}
