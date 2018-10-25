package com.company.controller;

import com.company.model.Vacancy;
import com.company.service.UserService;
import com.company.service.VacancyService;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET)
    public String getVacancy(@PathVariable int id, ModelMap vacancyModel) {
        vacancyModel.addAttribute("vacancy", vacancyService.getVacancy(id));
        return "vacancyInfo";
    }

    @RequestMapping(value = "/allVacancies", method = RequestMethod.GET)
    public String getVacancies(ModelMap vacancyModel) {
        vacancyModel.addAttribute("vacancy", vacancyService.getAllVacancies());
        return "allVacancies";
    }

    @RequestMapping(value = "/vacancy/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        model.addAttribute("vacancy",new Vacancy());
        return "addVacancy";
    }

    @RequestMapping(value = "/vacancy/add.do", method = RequestMethod.POST)
    public String addVacancy(@Valid Vacancy vacancy, BindingResult bindingResult, ModelMap vacancyModel) {
        if(bindingResult.hasErrors()){
            return "addVacancy";
        }
        vacancyModel.addAttribute("vacancy", vacancy);
        int resp = vacancyService.addVacancy(vacancy);
        if (resp > 0) {
            vacancyModel.addAttribute("msg",
                    "Vacancy with id : " + resp +
                    " added successfully");
            vacancyModel.addAttribute("vacancy",
                    vacancyService.getAllVacancies());
            return "allVacancies";
        } else {
            vacancyModel.addAttribute("msg",
                    "Vacancy addition failed.");
            return "addVacancy";
        }
    }

    @RequestMapping(value = "/vacancy/delete/{id}", method = RequestMethod.GET)
    public String deleteVacancy(@PathVariable("id") int id, ModelMap vacancyModel) {
        int resp = vacancyService.deleteVacancy(id);
        vacancyModel.addAttribute("vacancy",
                vacancyService.getAllVacancies());
        if (resp > 0) {
            vacancyModel.addAttribute("msg",
                    "Vacancy with id : " + id + " deleted successfully.");
        } else {
            vacancyModel.addAttribute("msg",
                    "Vacancy with id : " + id + " deletion failed.");
        }
        return "allVacancies";
    }

    @RequestMapping(value = "/vacancy/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap vacancyModel) {
        vacancyModel.addAttribute("id", id);
        vacancyModel.addAttribute("vacancy",
                vacancyService.getVacancy(id));
        return "updateVacancy";
    }

    @RequestMapping(value = "/vacancy/update", method = RequestMethod.POST)
    public String updateVacancy(@RequestParam int id,
                                @RequestParam(value = "pos", required = true) String pos,
                                @RequestParam(value = "sal_from", required = true) Double sal_from,
                                @RequestParam(value = "sal_to", required = true) Double sal_to,
                                @RequestParam(value = "vac_state", required = true) String vac_state,
                                @RequestParam(value = "exp_years", required = true) Double exp_years,
                                @RequestParam(value = "dev_id", required = true) int dev_id,
                                ModelMap vacancyModel) {
        {
            Vacancy vacancy = new Vacancy();
            vacancy.setPosition(pos);
            vacancy.setSalary_from(sal_from);
            vacancy.setSalary_to(sal_to);
            vacancy.setVacancy_state(vac_state);
            vacancy.setExperience_years_require(exp_years);
            vacancy.setDeveloper_id(dev_id);
            int resp = vacancyService.updateVacancy(vacancy);
            vacancyModel.addAttribute("id", id);
            if (resp > 0) {
                vacancyModel.addAttribute("msg",
                        "Vacancy with id : " + id +
                                " updated successfully ");
                vacancyModel.addAttribute("vacancy",
                        vacancyService.getAllVacancies());
                return "allVacancies";
            } else {
                vacancyModel.addAttribute("msg",
                        "Vacancy with id : " + id + " updating failed.");
                vacancyModel.addAttribute("vacancy",
                        vacancyService.getVacancy(id));
                return "updateVacancy";
            }
        }
    }
    @ModelAttribute("developerIDList")
    public List<String> getUserDeveloperList() {
        List<String> idList = userService.getDeveloperId();
        // добавляем id только тех юзеров, кто является developer
        return idList;
    }
}
