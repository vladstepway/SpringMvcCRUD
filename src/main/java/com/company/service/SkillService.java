package com.company.service;

import com.company.model.Skill;

import java.util.List;

public interface SkillService {
    Skill getSkill(String name);

    List<Skill> getAllSkills();

    int addSkill(Skill skill);

    int updateSkill(Skill skill);

    int deleteSkill(String name);
}
