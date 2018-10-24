package com.company.dao;

import com.company.model.Interview;

import java.util.List;

public interface InterviewDao {
    public Interview getInterview(int id);

    public List<Interview> getAllInterviews();
    public List<String> getAllInterviewsID();


    public int addInterview(Interview interview);

    public int updateInterview(Interview interview);

    public int deleteInterview(int id);
}
