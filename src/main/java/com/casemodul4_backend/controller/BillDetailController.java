package com.casemodul4_backend.controller;

import com.casemodul4_backend.model.BillDetail;
import com.casemodul4_backend.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/billdetails")
public class BillDetailController {
    @Autowired
    BillDetailService billDetailService;

    @GetMapping
    public List<BillDetail> showAllBillDetail() {
        return ( billDetailService.findAll());
    }
    //    Thêm sản phẩm
    @PostMapping
    public void create (@RequestBody BillDetail billDetail){
        billDetailService.save(billDetail);
    }
    //    Hiển thị sản phẩm muốn sửa
    @GetMapping("/{id}")
    public BillDetail showEdit(@PathVariable int id){
        return billDetailService.findById(id).get();
    }
    //    Sửa sản phẩm
    @PutMapping("/{id}")
    public void saveEdit(@RequestBody BillDetail billDetail){
        billDetailService.save(billDetail);

    }
    //    Xóa sản phẩm
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        billDetailService.delete(id);
    }

    @GetMapping("/findBillDetailById/{id}")
    public List<BillDetail> findByIdProduct(@PathVariable int id){
        return
                billDetailService.findByIdAccount(id);
    }

}
