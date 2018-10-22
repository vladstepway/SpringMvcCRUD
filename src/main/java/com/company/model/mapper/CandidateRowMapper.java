package com.company.model.mapper;

import com.company.model.Candidate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateRowMapper implements RowMapper<Candidate> {
    @Override
    public Candidate mapRow(ResultSet resultSet, int row) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(resultSet.getInt("id"));
        candidate.setName(resultSet.getString("name"));
        candidate.setSurname(resultSet.getString("surname"));
        candidate.setBirthday(resultSet.getString("birthday"));
        candidate.setExpected_salary(resultSet.getDouble("expected_salary"));
        candidate.setCandidate_state(resultSet.getString("candidate_state"));
        return candidate;
    }
}