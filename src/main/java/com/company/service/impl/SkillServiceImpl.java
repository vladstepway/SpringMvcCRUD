package com.company.service.impl;

import com.company.dao.SkillDao;
import com.company.model.Skill;
import com.company.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillDao skillDao;

    public Skill getSkill(String name) {
        return skillDao.getSkill(name);
    }

    public List<Skill> getAllSkills() {
        return skillDao.getAllSkills();
    }

    @Override
    public int addSkill(Skill skill) {
        return skillDao.addSkill(skill);
    }

    @Override
    public int updateSkill(Skill skill) {
        return skillDao.updateSkill(skill);
    }

    @Override
    public int deleteSkill(String name) {
        return skillDao.deleteSkill(name);
    }

    public SkillDao getSkillDao() {
        return skillDao;
    }
}
