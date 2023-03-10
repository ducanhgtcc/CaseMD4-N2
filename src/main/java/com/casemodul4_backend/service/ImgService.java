package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.repository.ImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImgService {
    @Autowired
    ImgRepo imgRepo;


    public List<Img> findAll() {
        return (List<Img>) imgRepo.findAll();
    }


    public Optional<Img> findById(int id) {
        return imgRepo.findById(id);
    }


    public void save(Img img) {
        imgRepo.save(img);

    }


    public void delete(int id) {
        imgRepo.deleteById(id);

    }


    public List<Img> findImgByProduct_Name(int id) {
        return imgRepo.findImgByProduct_Id(id);
    }

//    public List<Img> findImgByProduct_Name(String name) {
//        return imgRepo.findImgByProduct_NameOrderByProduct(name);
//    }

    public List<Img> findByIdProduct(int idProduct) {
        List<Img> newlist = new ArrayList<>();

        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getProduct().getId() == idProduct) {
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }

}
