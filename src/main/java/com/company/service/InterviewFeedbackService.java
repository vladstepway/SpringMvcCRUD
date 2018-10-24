package com.company.service;

import com.company.model.InterviewFeedback;

import java.util.List;

public interface InterviewFeedbackService {
     InterviewFeedback getInterviewFeedback(int id);

     List<InterviewFeedback> getAllInterviewFeedbacks();
     List<String> getFeedbackStates();

     int addInterviewFeedback(InterviewFeedback interviewFeedback);

     int updateInterviewFeedback(InterviewFeedback interviewFeedback);

     int deleteInterviewFeedback(int id);
}
