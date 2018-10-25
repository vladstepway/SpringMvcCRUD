package com.company.controller;

import com.company.model.Candidate;
import com.company.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CandidateController {


    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "candidate/{id}", method = RequestMethod.GET)
    public String getCandidate(@PathVariable int id, ModelMap candidateModel) {
        candidateModel.addAttribute("candidate", candidateService.getCandidate(id));
        return "candidateInfo";
    }

    @RequestMapping(value = "/allCandidates", method = RequestMethod.GET)
    public String getAllCandidates(ModelMap candidateModel) {
        candidateModel.addAttribute("candidate", candidateService.getAllCandidates());
        return "allCandidates";
    }

    @RequestMapping(value = "/candidate/add")
    public String addPage(Model model) {
        model.addAttribute("candidate",new Candidate());
        return "addCandidate";
    }

    @RequestMapping(value = "/candidate/add.do", method = RequestMethod.POST)
    public String addCandidate(@Valid Candidate candidate, BindingResult bindingResult,
                               ModelMap candidateModel) {
        if(bindingResult.hasErrors()){
            return "addCandidate";
        }

        candidateModel.addAttribute("candidate", candidate);
        int resp = candidateService.addCandidate(candidate);
        if (resp > 0) {
            candidateModel.addAttribute("msg", "Candidate with id : " + resp + " added successfully.");
            candidateModel.addAttribute("candidate", candidateService.getAllCandidates());
            return "allCandidates";
        } else {
            candidateModel.addAttribute("msg", "Candidate addition failed.");
            return "addCandidate";
        }
    }

    @RequestMapping(value = "/candidate/delete/{id}", method = RequestMethod.GET)
    public String deleteCandidate(@PathVariable("id") int id, ModelMap candidateModel) {
        int resp = candidateService.deleteCandidate(id);
        candidateModel.addAttribute("candidate", candidateService.getAllCandidates());
        if (resp > 0) {
            candidateModel.addAttribute("msg", "Candidate with id : " + id + " deleted successfully.");
        } else {
            candidateModel.addAttribute("msg", "Candidate with id : " + id + " deletion failed.");
        }
        return "allCandidates";
    }

    @RequestMapping(value = "/candidate/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap candidateModel) {
        candidateModel.addAttribute("id", id);
        candidateModel.addAttribute("candidate", candidateService.getCandidate(id));
        return "updateCandidate";
    }

    @RequestMapping(value = "/candidate/update", method = RequestMethod.POST)
    public String updateCandidate(@RequestParam int id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "sname", required = true) String sname,
                             @RequestParam(value = "bday", required = true) String bday,
                             @RequestParam(value = "exp_salary", required = true) Double exp_salary,
                             @RequestParam(value = "cand_state", required = true) String cand_state,
                             ModelMap candidateModel) {
        Candidate candidate = new Candidate();
        candidate.setName(name);
        candidate.setSurname(sname);
        candidate.setBirthday(bday);
        candidate.setExpected_salary(exp_salary);
        candidate.setCandidate_state(cand_state);
        int resp = candidateService.updateCandidate(candidate);
        candidateModel.addAttribute("id", id);
        if (resp > 0) {
            candidateModel.addAttribute("msg", "Candidate with id : " + id + " updated successfully.");
            candidateModel.addAttribute("candidate", candidateService.getAllCandidates());
            return "allCandidates";
        } else {
            candidateModel.addAttribute("msg", "Candidate with id : " + id + " updating failed.");
            candidateModel.addAttribute("candidate", candidateService.getCandidate(id));
            return "updateCandidate";
        }
    }

    @ModelAttribute("candidateStateList")
    public List<String> getCandidateStateList() {
        return candidateService.getListOfStates();
    }




}
