package com.mehdi.other.architecture.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Posts {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String price;
    private String body;
    private String cover;
    private String status = "pending";
    private String code = RandomString.make(20);







    @Transient
    @JsonIgnore
    private MultipartFile file;

    @ManyToOne
    private Users users;

    public Posts() {

    }



    public Posts(String name, String price, String body, String cover, String status) {
        this.name = name;
        this.price = price;
        this.body = body;
        this.cover = cover;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getStatus() {
        return status;
    }

    public Posts setStatus(String status) {
        this.status = status;
        return null;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
