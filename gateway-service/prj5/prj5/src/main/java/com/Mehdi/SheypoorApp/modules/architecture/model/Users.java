package com.Mehdi.SheypoorApp.modules.architecture.model;

import com.Mehdi.SheypoorApp.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Users implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    @Column(unique = true)
    private String phoneNumber;


    private boolean enabled=true;


    @OneToMany(mappedBy = "users")
    private List<Posts> posts;

    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name="authorities", joinColumns =
    @JoinColumn(name = "email",referencedColumnName = "email"))
    @Enumerated(EnumType.STRING)
    private List<Roles> roles;



    public Users(){

    }

    public Users(String email, String password, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public Users setEmail(String email) {
        System.out.println("mahdi");
        this.email = email;
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        System.out.println("phone");
        this.phoneNumber = phoneNumber;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }





    public List<Roles> getRoles() {
        return roles;
    }

    public Users setRoles(List<Roles> roles) {
        System.out.println("liva");
        this.roles = roles;
        return null;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
