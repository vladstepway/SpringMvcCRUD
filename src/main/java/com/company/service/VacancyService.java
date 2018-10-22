package com.company.service;

import com.company.model.Vacancy;

import java.util.List;

public interface VacancyService {

    Vacancy getVacancy(int id);

    List<Vacancy> getAllVacancies();

    int addVacancy(Vacancy vacancy);

    int updateVacancy(Vacancy vacancy);

    int deleteVacancy(int id);
}
