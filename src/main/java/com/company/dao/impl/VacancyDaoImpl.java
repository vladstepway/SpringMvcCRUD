package com.company.dao.impl;

import com.company.dao.VacancyDao;
import com.company.model.Vacancy;
import com.company.model.mapper.VacancyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VacancyDaoImpl implements VacancyDao {

    private static final String QUERY_TO_SELECT_VACANCY =
            "SELECT * FROM vacancy WHERE id = ?";
    private static final String QUERY_TO_SELECT_ALL_VACANCY =
            "SELECT * FROM vacancy";
    private static final int NUMBER_OF_PARAMETERS = 6;
    private static final String QUERY_TO_DELETE_VACANCY = "DELETE FROM vacancy WHERE id = ?";
    private static final String QUERY_TO_UPDATE_VACANCY = "UPDATE vacancy SET " +
            "position = ?," +
            " salary_from = ?," +
            " salary_to = ?, " +
            "vacancy_state = ?," +
            "experience_years_require = ?," +
            "developer_id = ?," +
            " where id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Vacancy getVacancy(int id) {
        return jdbcTemplate.queryForObject(QUERY_TO_SELECT_VACANCY,
                new Object[]{id}, new VacancyRowMapper());
    }

    @Transactional
    public List<Vacancy> getAllVacancy() {
        return jdbcTemplate.query(QUERY_TO_SELECT_ALL_VACANCY, new VacancyRowMapper());
    }
    public List<String> getAllVacancyID(){
        return jdbcTemplate.queryForList("select id from vacancy", String.class);
    }
    @Transactional
    public int addVacancy(Vacancy vacancy) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("vacancy").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(NUMBER_OF_PARAMETERS);
        parameters.put("position", vacancy.getPosition());
        parameters.put("salary_from", vacancy.getSalary_from());
        parameters.put("salary_to", vacancy.getSalary_to());
        parameters.put("vacancy_state", vacancy.getVacancy_state());
        parameters.put("experience_years_require", vacancy.getExperience_years_require());
        parameters.put("developer_id", vacancy.getDeveloper_id());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateVacancy(Vacancy vacancy) {
        return jdbcTemplate.update(QUERY_TO_UPDATE_VACANCY,
                vacancy.getPosition(),
                vacancy.getSalary_from(),
                vacancy.getSalary_to(),
                vacancy.getVacancy_state(),
                vacancy.getExperience_years_require(),
                vacancy.getDeveloper_id());
    }

    @Transactional
    public int deleteVacancy(int id) {
        return jdbcTemplate.update(QUERY_TO_DELETE_VACANCY, id);
    }
}
