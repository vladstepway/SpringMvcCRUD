package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable int id, ModelMap userModel) {
        userModel.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap userModel) {
        userModel.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult,
                          Model userModel) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        userModel.addAttribute("user", user);

        int resp = userService.addUser(user);
        if (resp > 0) {
            userModel.addAttribute("msg", "User with id : " + resp + " added successfully.");
            userModel.addAttribute("user", userService.getAllUsers());
            return "users";
        } else {
            userModel.addAttribute("msg", "User addition failed.");
           return "add";
        }
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id, ModelMap userModel) {
        int resp = userService.deleteUser(id);
        userModel.addAttribute("user", userService.getAllUsers());
        if (resp > 0) {
            userModel.addAttribute("msg", "User with id : " + id + " deleted successfully.");
        } else {
            userModel.addAttribute("msg", "User with id : " + id + " deletion failed.");
        }
        return "users";
    }

    @RequestMapping(value = "/update/user/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap userModel) {
        userModel.addAttribute("id", id);
        userModel.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult bindingResult,
                             Model userModel) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        userModel.addAttribute("user", user);

        int resp = userService.updateUser(user);
        userModel.addAttribute("id", user.getId());
        if (resp > 0) {
            userModel.addAttribute("msg", "User with id : " + user.getId() + " updated successfully.");
            userModel.addAttribute("user", userService.getAllUsers());
            return "users";
        } else {
            userModel.addAttribute("msg", "User with id : " + user.getId() + " update failed.");
            userModel.addAttribute("user", userService.getUser(user.getId()));
            return "update";
        }
    }

}