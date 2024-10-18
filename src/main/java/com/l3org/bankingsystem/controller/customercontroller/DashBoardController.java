package com.l3org.bankingsystem.controller.customercontroller;

import com.l3org.bankingsystem.model.Account;
import com.l3org.bankingsystem.model.CustomerUser;
import com.l3org.bankingsystem.model.User;
import com.l3org.bankingsystem.service.AccountService;
import com.l3org.bankingsystem.service.CustomerUserService;
import com.l3org.bankingsystem.service.LoginService;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"otp", "account","user","successAlert","errorAlert"})
public class DashBoardController {
    private AccountService accountService;
    private CustomerUserService customerUserService;

    public DashBoardController(AccountService accountService, CustomerUserService customerUserService) {
        this.accountService = accountService;
        this.customerUserService = customerUserService;
    }
    @GetMapping("/customer-dashboard/home")
    public String home() {
        return "customer-dashboard/home";
    }

    @GetMapping("/addAccountForm")
    public String getAccountForm(Model model) {
        return "/customer-dashboard/add-account-form";
    }
    @PostMapping("/submitDetails")
    public String postAccountForm(
            @RequestParam(required = false) String mobileNumber,
            @RequestParam(required = false) String aadhaarNumber,
            Model model
    ){
        Account account = null;
        if(mobileNumber!=null){
            try {
                account = accountService.getAccountByMobileNumber(mobileNumber);
                model.addAttribute("otp", "1234");
                model.addAttribute("account", account);
                return "/customer-dashboard/verify-otp";
            }
            catch(FieldValueNotFoundException e){
                model.addAttribute(e.getFieldName(),e.getMessage());
            }
        }
        else{
            try{
                account = accountService.getAccountByAadhaarNumber(aadhaarNumber);
                model.addAttribute("otp", "1234");
                model.addAttribute("account", account);
                return "/customer-dashboard/verify-otp";
            }
            catch(FieldValueNotFoundException e){
                model.addAttribute(e.getFieldName(),e.getMessage());
            }
        }
        return "/customer-dashboard/add-account-form";
    }
    @GetMapping("/customer-dashboard/verify-otp")
    public String getVerifyOtp() {
        return "/customer-dashboard/verify-otp";
    }

    @PostMapping("customer-dashboard/verify-otp")
    public String postVerifyOtp(
            @RequestParam String otp,
            Model model
    ){
        String validOtp = (String)model.getAttribute("otp");
        CustomerUser user = (CustomerUser)model.getAttribute("user");
        Account account = (Account)model.getAttribute("account");
        if(otp.equals(validOtp)&&account!=null){
            try{
                customerUserService.addAccount(user,account);
                model.addAttribute("successAlert","account added successfully");
            }
            catch(DuplicateKeyException e){
                model.addAttribute("errorAlert",e.getMessage());
            }
            return "redirect:/customer-dashboard/home";
        }
        model.addAttribute("error","invalid-otp");
        return "/customer-dashboard/verify-otp";
    }



}
