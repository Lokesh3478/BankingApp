package com.l3org.bankingsystem.controller;

import java.util.Date;

import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import com.l3org.bankingsystem.service.exceptions.InvalidPassWordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.l3org.bankingsystem.model.AdminUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.l3org.bankingsystem.model.User;
import com.l3org.bankingsystem.service.LoginService;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private LoginService loginService;

    // GET method for showing home page
    @GetMapping("/authentication/home")
    public String showHomePage() {
        return "authentication/home";
    }

    // GET method for showing login page
    @GetMapping("/authentication/login")
    public String showLoginPage() {
        return "authentication/login";
    }

    // POST method for login
    @PostMapping("/authentication/login")
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("password") String password,
                        Model model) {
        try{
            User user = loginService.customerUserLoginUsingUserId(userId,password);
            model.addAttribute("user", user);
            return "/customer-dashboard/home";
        } catch (FieldValueNotFoundException e) {
            model.addAttribute("userId",e.getMessage());
        }
        catch(InvalidPassWordException e) {
            model.addAttribute("invalidPassword",e.getMessage());
        }
        return "authentication/login";
    }

    // GET method for showing signup page
    @GetMapping("authentication/signup")
    public String showSignupPage() {
        return "authentication/signup";
    }

    // POST method for signup
    @PostMapping("/authentication/signup")
    public String signup(@RequestParam("userId") String userId,
                         @RequestParam("userName") String userName,
                         @RequestParam("mailId") String mailId,
                         @RequestParam("password") String password,
                         @RequestParam("mobileNumber") String mobileNumber,
                         @RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                         Model model) {
        try{
            User user = loginService.customerUserSignUp(userId, userName, mailId, password, mobileNumber, dob);
            model.addAttribute("user", user);
            System.out.println(user);
            return "redirect:customer-dashboard/home";
        } catch (Exception e) {
            model.addAttribute(e.getMessage(),e.getMessage()+" already exists");
            return "authentication/signup";
        }
    }

    // GET method for showing dashboard
    @GetMapping("/admin-dashboard/home")
    public String showCutomerDashboard() {
        return "customer-dashboard/home";
    }

    //Get method for showing admin dashboard

    // GET method for showing admin login page
    @GetMapping("/authentication/adminLogin")
    public String showAdminLoginPage() {
        return "authentication/adminLogin"; // Ensure this path matches your directory structure
    }

    // POST method for admin login
    @PostMapping("/authentication/adminLogin")
    public String adminLogin(@RequestParam("userId") String userId,
                             @RequestParam("adminCode") String adminCode,
                             @RequestParam("password") String password,
                             Model model) {
        // Implement your validation logic here, possibly adjusting your service method
        try{
            AdminUser user = loginService.adminUserLoginUsingUserId(userId,password);
            model.addAttribute("user", user);
            System.out.println(user);
            return "admin-dashboard/home";

        }catch (FieldValueNotFoundException e){
            model.addAttribute("userId",e.getMessage());
        }catch (InvalidPassWordException e){
            model.addAttribute("invalidPassword",e.getMessage());
        }
        return "authentication/adminLogin";
    }
}
