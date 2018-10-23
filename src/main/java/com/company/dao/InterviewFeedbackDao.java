package com.company.dao;

import com.company.model.InterviewFeedback;

import java.util.List;

public interface InterviewFeedbackDao {
    public InterviewFeedback getInterviewFeedback(int interview_id);

    public List<InterviewFeedback> getAllInterviewFeedbacks();

    public int addInterviewFeedback(InterviewFeedback interviewFeedback);

    public int updateInterviewFeedback(InterviewFeedback interviewFeedback);

    public int deleteInterviewFeedback(int interview_id);
}
