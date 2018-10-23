package com.company.model;

public class InterviewFeedback {

    private int interview_id;
    private int interviewer_id;
    private String feedback_state;
    private String reason;

    public int getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(int interview_id) {
        this.interview_id = interview_id;
    }

    public int getInterviewer_id() {
        return interviewer_id;
    }

    public void setInterviewer_id(int interviewer_id) {
        this.interviewer_id = interviewer_id;
    }

    public String getFeedback_state() {
        return feedback_state;
    }

    public void setFeedback_state(String feedback_state) {
        this.feedback_state = feedback_state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
