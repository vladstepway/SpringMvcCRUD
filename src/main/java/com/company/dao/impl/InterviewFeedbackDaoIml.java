package com.company.dao.impl;

import com.company.dao.InterviewFeedbackDao;
import com.company.model.InterviewFeedback;
import com.company.model.mapper.InterviewFeedbackRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewFeedbackDaoIml implements InterviewFeedbackDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public InterviewFeedback getInterviewFeedback(int interview_id) {
        InterviewFeedback InterviewFeedback = (InterviewFeedback) jdbcTemplate.queryForObject("select * from interview_feedback where interview_id = ?",
                new Object[] { interview_id }, new InterviewFeedbackRowMapper());
        return InterviewFeedback;
    }
    @Transactional
    public List<InterviewFeedback> getAllInterviewFeedbacks() {
        List<InterviewFeedback> InterviewFeedbacks = (List<InterviewFeedback>) jdbcTemplate.query("select * from interview_feedback",
                new InterviewFeedbackRowMapper());
        return InterviewFeedbacks;
    }

    @Transactional
    public List<String> getAllFeedbackStatess(){
        return jdbcTemplate.queryForList("select name from feedback_state", String.class);
    }
    @Transactional
    public int addInterviewFeedback(InterviewFeedback interviewFeedback) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("interview_feedback");
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("interview_id", interviewFeedback.getInterview_id());
        parameters.put("interviewer_id", interviewFeedback.getInterviewer_id());
        parameters.put("feedback_state", interviewFeedback.getFeedback_state());
        parameters.put("reason", interviewFeedback.getReason());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateInterviewFeedback(InterviewFeedback interviewFeedback) {
        String sql = "update interview_feedback set interviewer_id = ?, feedback_state = ?, reason = ? where interview_id = ?";
        int resp = jdbcTemplate.update(sql,
                new Object[] { interviewFeedback.getInterviewer_id(), interviewFeedback.getFeedback_state(),
                        interviewFeedback.getReason(),
                        interviewFeedback.getInterview_id() });
        return resp;
    }

    @Transactional
    public int deleteInterviewFeedback(int interview_id) {
        int resp = jdbcTemplate.update("delete from interview_feedback where interview_id = ?", interview_id);
        return resp;
    }


}