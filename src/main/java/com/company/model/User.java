package com.company.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @NotNull(message="FirstName cannot be empty")
    @Size(min=2, max=30)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min=2, max=30)
    private String surname;

    @NotEmpty
    @Email
    private String email;

    @Password
    @Size(min = 6, max = 20)
    private String password;

    private String userRole;


    public User() {
    }

    public User(int id, String firstName, String surname, String email, String password, String userRole) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}