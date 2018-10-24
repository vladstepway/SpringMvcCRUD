package com.company.model;

import java.util.Objects;

public class Vacancy {
    private int id;
    private String position;
    private Double salary_from;
    private Double salary_to;
    private String vacancy_state;
    private Double experience_years_require;
    private int developer_id;

    public Vacancy() {}

    public Vacancy(int id, String position,
                   Double salary_from,
                   Double salary_to,
                   String vacancy_state,
                   Double experience_years_require,
                   int developer_id) {
        this.id = id;
        this.position = position;
        this.salary_from = salary_from;
        this.salary_to = salary_to;
        this.vacancy_state = vacancy_state;
        this.experience_years_require = experience_years_require;
        this.developer_id = developer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary_from() {
        return salary_from;
    }

    public void setSalary_from(Double salary_from) {
        this.salary_from = salary_from;
    }

    public Double getSalary_to() {
        return salary_to;
    }

    public void setSalary_to(Double salary_to) {
        this.salary_to = salary_to;
    }

    public String getVacancy_state() {
        return vacancy_state;
    }

    public void setVacancy_state(String vacancy_state) {
        this.vacancy_state = vacancy_state;
    }

    public Double getExperience_years_require() {
        return experience_years_require;
    }

    public void setExperience_years_require(Double experience_years_require) {
        this.experience_years_require = experience_years_require;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return getId() == vacancy.getId() &&
                getDeveloper_id() == vacancy.getDeveloper_id() &&
                Objects.equals(getPosition(), vacancy.getPosition()) &&
                Objects.equals(getSalary_from(), vacancy.getSalary_from()) &&
                Objects.equals(getSalary_to(), vacancy.getSalary_to()) &&
                getVacancy_state() == vacancy.getVacancy_state() &&
                Objects.equals(getExperience_years_require(), vacancy.getExperience_years_require());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getPosition(),
                getSalary_from(),
                getSalary_to(),
                getVacancy_state(),
                getExperience_years_require(),
                getDeveloper_id());
    }


}
