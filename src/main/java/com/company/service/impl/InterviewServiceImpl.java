package com.company.service.impl;

import com.company.dao.InterviewDao;
import com.company.model.Interview;
import com.company.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewDao interviewDao;

    public Interview getInterview(int id) {
        return interviewDao.getInterview(id);
    }

    public List<Interview> getAllInterviews() {
        return interviewDao.getAllInterviews();
    }

    @Override
    public int addInterview(Interview user) {
        return interviewDao.addInterview(user);
    }

    @Override
    public int updateInterview(Interview user) {
        return interviewDao.updateInterview(user);
    }

    @Override
    public int deleteInterview(int id) {
        return interviewDao.deleteInterview(id);
    }

    public InterviewDao getInterviewDao() {
        return interviewDao;
    }
}
