package com.company.model.mapper;

import com.company.model.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillRowMapper implements RowMapper<Skill> {
    @Override
    public Skill mapRow(ResultSet resultSet, int row) throws SQLException {
        Skill skill = new Skill();
        skill.setName(resultSet.getString("name"));
        return skill;
    }
}
