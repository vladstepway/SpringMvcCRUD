package com.company.service.impl;

import com.company.dao.VacancyDao;
import com.company.model.Vacancy;
import com.company.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VacancyServiceImpl implements VacancyService {
    @Autowired
    private VacancyDao vacancyDao;

    @Override
    public Vacancy getVacancy(int id) {
        return vacancyDao.getVacancy(id);
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        return vacancyDao.getAllVacancy();
    }
    public List<String> getVacanciesID(){return vacancyDao.getAllVacancyID();}


    @Override
    public int addVacancy(Vacancy vacancy) {
        return vacancyDao.addVacancy(vacancy);
    }

    @Override
    public int updateVacancy(Vacancy vacancy) {
        return vacancyDao.updateVacancy(vacancy);
    }

    @Override
    public int deleteVacancy(int id) {
        return vacancyDao.deleteVacancy(id);
    }
}
