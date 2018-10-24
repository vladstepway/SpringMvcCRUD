package com.company.service;

import com.company.model.Interview;

import java.util.List;

public interface InterviewService {

     Interview getInterview(int id);

     List<Interview> getAllInterviews();
     List<String> getAllInterviewsID();


     int addInterview(Interview interview);

     int updateInterview(Interview interview);

     int deleteInterview(int id);

}