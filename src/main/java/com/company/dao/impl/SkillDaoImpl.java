package com.company.dao.impl;

import com.company.dao.SkillDao;
import com.company.model.Skill;
import com.company.model.mapper.SkillRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillDaoImpl implements SkillDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Skill getSkill(String name) {
        Skill skill = jdbcTemplate.queryForObject("select * from skill where name = ?",
                new Object[]{name}, new SkillRowMapper());
        return skill;
    }

    @Transactional
    public List<Skill> getAllSkills() {
        List<Skill> skillList = jdbcTemplate.query("select * from skill",
                new SkillRowMapper());
        return skillList;
    }


    @Transactional
    public int addSkill(Skill skill) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("skill").usingGeneratedKeyColumns("name");
        Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("name", skill.getName());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateSkill(Skill skill) {
        String sql = "update skill set name = ? where name = ?";
        int resp = jdbcTemplate.update(sql, skill.getName(), skill.getName());
        return resp;

    }

    @Transactional
    public int deleteSkill(String name) {
        int resp = jdbcTemplate.update("delete from skill where name = ?", name);
        return resp;
    }
}
