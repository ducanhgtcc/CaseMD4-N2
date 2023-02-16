package com.casemodul4_backend.service;

import com.casemodul4_backend.dto.CommentDto;
import com.casemodul4_backend.model.Account;
import com.casemodul4_backend.model.Comment;
import com.casemodul4_backend.repository.AccountRepository;
import com.casemodul4_backend.repository.CmtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CmtService implements InterfaceGeneral<Comment> {
    @Autowired
    CmtRepo cmtRepo;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) cmtRepo.findAll();
    }

    @Override
    public Optional<Comment> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Comment comment) {
        cmtRepo.save(comment);
    }

    @Override
    public void delete(int id) {

    }

    public List<Comment> findByIdProduct(int idProduct) {
        List<Comment> newlist = new ArrayList<>();

        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getProduct().getId() == idProduct) {
                newlist.add(findAll().get(i));
            }
        }
        return newlist;
    }


    public List<CommentDto> findAllCommentDtoByAccountId(Integer id) {
        final List<CommentDto> commentDtoList = new ArrayList<>();

        for (int i = 0; i < cmtRepo.findAllById(id).size(); i++) {
            CommentDto commentDto = new CommentDto();
            if (cmtRepo.findAllById(id).get(i).getProduct().getId() == id) {
                commentDto.setId(cmtRepo.findAllById(id).get(i).getId());
                commentDto.setAccountId(cmtRepo.findAllById(id).get(i).getAccount().getId());
                commentDto.setContent(cmtRepo.findAllById(id).get(i).getContent());
                commentDto.setProductId((cmtRepo.findAllById(id).get(i).getProduct().getId()));
                commentDtoList.add(commentDto);
            }
        }
        return commentDtoList;
    }

    public List<Account> getAllAccountById(Integer id) {
        return accountRepository.findAllById(id);
    }

    public <Optinal> Account getAccountById(Integer id) {
        return accountRepository.findById(id).get();
    }

}
