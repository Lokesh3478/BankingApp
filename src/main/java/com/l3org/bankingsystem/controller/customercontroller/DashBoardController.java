package com.l3org.bankingsystem.controller.customercontroller;

import com.l3org.bankingsystem.model.Account;
import com.l3org.bankingsystem.model.CustomerUser;
import com.l3org.bankingsystem.model.User;
import com.l3org.bankingsystem.service.AccountService;
import com.l3org.bankingsystem.service.CustomerUserService;
import com.l3org.bankingsystem.service.LoginService;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"otp", "account","user","message"})
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
                //OTP logic to be made by Lalith Kumar
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
                //OTP logic to be made by Lalith Kumar
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
            model.addAttribute("message","account added successfully");
            customerUserService.addAccount(user,account);
            return "redirect:/customer-dashboard/home";
        }
        model.addAttribute("otpError","invalid-otp");
        return "/customer-dashboard/verify-otp";
    }



}
