package com.company.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

public class Interview {
    private int id;

    @Date
    private String plan_date;
    @Date
    private String fact_date;

    @NotNull
    private int vacancy_id;
    @NotNull
    private int candidate_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(String plan_date) {
        this.plan_date = plan_date;
    }

    public String getFact_date() {
        return fact_date;
    }

    public void setFact_date(String fact_date) {
        this.fact_date = fact_date;
    }

    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

}
