package com.company.service;

import com.company.model.InterviewFeedback;

import java.util.List;

public interface InterviewFeedbackService {
    public InterviewFeedback getInterviewFeedback(int id);

    public List<InterviewFeedback> getAllInterviewFeedbacks();

    public int addInterviewFeedback(InterviewFeedback interviewFeedback);

    public int updateInterviewFeedback(InterviewFeedback interviewFeedback);

    public int deleteInterviewFeedback(int id);
}
