package com.casemodul4_backend.service;

import com.casemodul4_backend.model.Img;
import com.casemodul4_backend.repository.ImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImgService implements InterfaceGeneral<Img>{
    @Autowired
    ImgRepo imgRepo;


    @Override
    public List<Img> findAll() {
        return (List<Img>) imgRepo.findAll();
    }

    @Override
    public Optional<Img> findById(int id) {
        return imgRepo.findById(id);
    }

    @Override
    public void save(Img img) {
        imgRepo.save(img);

    }

    @Override
    public void delete(int id) {
        imgRepo.deleteById(id);

    }

    public  List<Img> findByIdProduct(int idProduct){
        List<Img> newlist = new ArrayList<>();

        for (int i=0; i< findAll().size();i++){
            if (findAll().get(i).getProduct().getId()==idProduct){
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }
}
