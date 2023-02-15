package com.casemodul4_backend.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.casemodul4_backend.model.Comment} entity
 */

public class CommentDto implements Serializable {
    private  Integer id;
    private  String content;
    private  Integer accountId;
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public CommentDto(Integer id, String content, Integer accountId, Integer productId) {
        this.id = id;
        this.content = content;
        this.accountId = accountId;
        this.productId = productId;
    }

    public CommentDto() {
    }


}