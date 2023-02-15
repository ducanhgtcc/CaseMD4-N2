package com.casemodul4_backend.model;



import javax.persistence.*;
import java.util.Objects;

@Entity

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String content;

    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    public Account account;
    @ManyToOne
    public Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Comment() {
    }

    public Comment(int id, String content, Account account, Product product) {
        this.id = id;
        this.content = content;
        this.account = account;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && Objects.equals(content, comment.content) && Objects.equals(account, comment.account) && Objects.equals(product, comment.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, account, product);
    }


}
