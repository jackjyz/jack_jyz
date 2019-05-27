package com.zzti.bookstore.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "userinfo")
public class Userinfo {

    @Id
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}
