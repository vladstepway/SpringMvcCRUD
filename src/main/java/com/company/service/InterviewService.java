package com.company.service;

import com.company.model.Interview;

import java.util.List;

public interface InterviewService {

    public Interview getInterview(int id);

    public List<Interview> getAllInterviews();

    public int addInterview(Interview interview);

    public int updateInterview(Interview interview);

    public int deleteInterview(int id);

}