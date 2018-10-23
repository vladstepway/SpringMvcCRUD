package com.company.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password paramA) {}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext ctx) {
        if(password == null){
            return false;
        }
        if (password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")) return true;
        else return false;
    }

}