package com.company.controller;


import com.company.model.InterviewFeedback;
import com.company.service.InterviewFeedbackService;
import com.company.service.InterviewService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InterviewFeedbackController {

    @Autowired
    private InterviewFeedbackService interviewFeedbackService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/interviewFeedback/{id}", method = RequestMethod.GET)
    public String getInterviewFeedback(@PathVariable int id, ModelMap interviewFeedbackModel) {
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getInterviewFeedback(id));
        return "interviewFeedbackInfo";
    }

    @RequestMapping(value = "/allInterviewFeedbacks", method = RequestMethod.GET)
    public String getInterviewFeedbacks(ModelMap interviewFeedbackModel) {
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
        return "allInterviewFeedbacks";
    }

    @RequestMapping(value = "/interviewFeedback/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        model.addAttribute("interviewFeedback", new InterviewFeedback());
        return "addInterviewFeedback";
    }

    @RequestMapping(value = "/interviewFeedback/add.do", method = RequestMethod.POST)
    public String addInterviewFeedback(@Valid InterviewFeedback interviewFeedback, BindingResult bindingResult,
                                       Model interviewFeedbackModel) {
        if (bindingResult.hasErrors()) {
            return "addInterviewFeedback";
        }
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedback);

        int resp = interviewFeedbackService.addInterviewFeedback(interviewFeedback);
        if (resp > 0) {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback with id : " + resp + " added successfully.");
            interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
            return "allInterviewFeedbacks";
        } else {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback addition failed.");
            return "addInterviewFeedback";
        }
    }

    @RequestMapping(value = "/interviewFeedback/delete/{id}", method = RequestMethod.GET)
    public String deleteInterviewFeedback(@PathVariable("id") int id, ModelMap interviewFeedbackModel) {
        int resp = interviewFeedbackService.deleteInterviewFeedback(id);
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
        if (resp > 0) {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback with id : " + id + " deleted successfully.");
        } else {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback with id : " + id + " deletion failed.");
        }
        return "allInterviewFeedbacks";
    }

    @RequestMapping(value = "/interviewFeedback/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap interviewFeedbackModel) {
        interviewFeedbackModel.addAttribute("id", id);
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getInterviewFeedback(id));
        return "updateInterviewFeedback";
    }

    @RequestMapping(value = "/interviewFeedback/update", method = RequestMethod.POST)
    public String updateInterviewFeedback(@Valid InterviewFeedback interviewFeedback, BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            return "updateInterviewFeedback";
        }
        model.addAttribute("interviewFeedback", interviewFeedback);

        int resp = interviewFeedbackService.updateInterviewFeedback(interviewFeedback);
        model.addAttribute("id", interviewFeedback.getInterview_id());
        if (resp > 0) {
            model.addAttribute("msg", "InterviewFeedback with id : " + interviewFeedback.getInterview_id() + " updated successfully.");
            model.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
            return "allInterviewFeedbacks";
        } else {
            model.addAttribute("msg", "InterviewFeedback with id : " + interviewFeedback.getInterview_id() + " update failed.");
            model.addAttribute("interviewFeedback", interviewFeedbackService.getInterviewFeedback(interviewFeedback.getInterview_id()));
            return "updateInterviewFeedback";
        }
    }
    @ModelAttribute("interviewIdList")
    public List<String> getInterviewIdList() {
        List<String> idList = interviewService.getAllInterviewsID();
        return idList;
    }
    @ModelAttribute("interviewerIdList")
    public List<String> getInterviewerIdList() {
        List<String> idList = userService.getInterviewerId();
        return idList;
    }
    @ModelAttribute("feedbackStatesList")
    public List<String> getFeedbackStatesList() {
        List<String> idList = interviewFeedbackService.getFeedbackStates();
        return idList;
    }
}
