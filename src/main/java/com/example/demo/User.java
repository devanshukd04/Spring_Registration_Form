package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user_form")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
    @NotEmpty @Column(name="Name")
    private String name;
    @NotEmpty @Email @Column(name="Email")
    private String email;
    @Size(min=3,max=50) @Column(name="Password")
    private String passwd;

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
