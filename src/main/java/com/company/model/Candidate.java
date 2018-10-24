package com.company.model;


import javax.validation.constraints.NotNull;

public class Candidate {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Date
    private String birthday;
    private Double expected_salary;
    private String candidate_state;

    public Candidate() {}

    public Candidate(int id, String name, String surname, String birthday, Double expected_salary, String candidate_state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.expected_salary = expected_salary;
        this.candidate_state = candidate_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getExpected_salary() {
        return expected_salary;
    }

    public void setExpected_salary(Double expected_salary) {
        this.expected_salary = expected_salary;
    }

    public String getCandidate_state() {
        return candidate_state;
    }

    public void setCandidate_state(String candidate_state) {
        this.candidate_state = candidate_state;
    }
}
