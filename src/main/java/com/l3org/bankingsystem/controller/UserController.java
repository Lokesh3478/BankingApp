package com.l3org.bankingsystem.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.l3org.bankingsystem.model.User;
import com.l3org.bankingsystem.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // GET method for showing home page
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    // GET method for showing login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // POST method for login
    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("password") String password,
                        Model model) {
        User user = userService.loginUsingUserId(userId, password);
        if (user != null && user.getPersonalInformation().getPassword().equals(password)) {
            model.addAttribute("user", user);
            return "dashboard"; // Redirect to dashboard after successful login
        } else {
            model.addAttribute("error", "Invalid userId or password.");
            return "login";
        }
    }

    // GET method for showing signup page
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    // POST method for signup
    @PostMapping("/signup")
    public String signup(@RequestParam("userId") String userId,
                         @RequestParam("userName") String userName,
                         @RequestParam("mailId") String mailId,
                         @RequestParam("password") String password,
                         @RequestParam("mobileNumber") String mobileNumber,
                         @RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                         Model model) {
        User user = userService.signUp(userId, userName, mailId, password, mobileNumber, dob);
        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard"; // Redirect to dashboard after successful signup
        } else {
            model.addAttribute("error", "Signup failed. Try again.");
            return "signup";
        }
    }

    // GET method for showing dashboard
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // Dashboard JSP
    }
}
