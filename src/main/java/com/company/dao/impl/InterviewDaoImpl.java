package com.company.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Interview;
import com.company.model.mapper.InterviewRowMapper;
import com.company.dao.InterviewDao;

public class InterviewDaoImpl implements InterviewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Interview getInterview(int id) {
        Interview interview = (Interview) jdbcTemplate.queryForObject("select * from interview where id = ?",
                new Object[] { id }, new InterviewRowMapper());
        return interview;
    }
    @Transactional
    public List<Interview> getAllInterviews() {
        List<Interview> interviews = (List<Interview>) jdbcTemplate.query("select * from interview",
                new InterviewRowMapper());
        return interviews;
    }
    @Transactional
    public List<String> getAllInterviewsID() {
        List<String> id = jdbcTemplate.queryForList("select id from interview", String.class);
        return id;
    }
    @Transactional
    public int addInterview(Interview interview) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("interview").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("plan_date",interview.getPlan_date());
        parameters.put("fact_date", interview.getFact_date());
        parameters.put("vacancy_id", interview.getVacancy_id());
        parameters.put("candidate_id", interview.getCandidate_id());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateInterview(Interview interview) {
        String sql = "update interview set plan_date = ?, fact_date = ?, vacancy_id = ?, candidate_id = ? where id = ?";
        int resp = jdbcTemplate.update(sql,
                new Object[] { interview.getPlan_date(), interview.getFact_date(),
                        interview.getCandidate_id(), interview.getVacancy_id(),
                        interview.getId() });
        return resp;
    }

    @Transactional
    public int deleteInterview(int id) {
        int resp = jdbcTemplate.update("delete from interview where id = ?", id);
        return resp;
    }


}