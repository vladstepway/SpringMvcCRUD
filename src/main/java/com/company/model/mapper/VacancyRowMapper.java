package com.company.model.mapper;

import com.company.model.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VacancyRowMapper implements RowMapper<Vacancy> {

    @Override
    public Vacancy mapRow(ResultSet resultSet, int row) throws SQLException {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(resultSet.getInt("id"));
        vacancy.setPosition(resultSet.getString("position"));
        vacancy.setSalary_from(resultSet.getDouble("salary_from"));
        vacancy.setSalary_to(resultSet.getDouble("salary_to"));
        vacancy.setVacancy_state(resultSet.getString("vacancy_state"));
        vacancy.setExperience_years_require(resultSet.getDouble("experience_years_require"));
        vacancy.setDeveloper_id(resultSet.getInt("developer_id"));
        return vacancy;
    }
}
