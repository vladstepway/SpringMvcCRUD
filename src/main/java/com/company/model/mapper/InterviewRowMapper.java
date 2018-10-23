package com.company.model.mapper;

import com.company.model.Interview;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterviewRowMapper implements RowMapper<Interview> {

    public Interview mapRow(ResultSet rs, int row) throws SQLException {
        Interview interview = new Interview();
        interview.setId(rs.getInt("id"));
        interview.setPlan_date(rs.getString("plan_date"));
        interview.setFact_date(rs.getString("fact_date"));
        interview.setVacancy_id(rs.getInt("vacancy_id"));
        interview.setCandidate_id(rs.getInt("candidate_id"));
        return interview;
    }
}

