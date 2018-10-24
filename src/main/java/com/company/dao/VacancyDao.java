package com.company.dao;

import com.company.model.Vacancy;

import java.util.List;

public interface VacancyDao {

    Vacancy getVacancy(int id);

    List<Vacancy> getAllVacancy();

    List<String> getAllVacancyID();


    int addVacancy(Vacancy vacancy);

    int updateVacancy(Vacancy vacancy);

    int deleteVacancy(int id);
}
