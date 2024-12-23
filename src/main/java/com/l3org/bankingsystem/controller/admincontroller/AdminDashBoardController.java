package com.l3org.bankingsystem.controller.admincontroller;
import java.util.Date;

import com.l3org.bankingsystem.model.Account;
import com.l3org.bankingsystem.model.AccountType;
import com.l3org.bankingsystem.model.Branch;
import com.l3org.bankingsystem.service.AdminService;
import com.l3org.bankingsystem.service.BranchService;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Controller
public class AdminDashBoardController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private BranchService branchService;

    public AdminDashBoardController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin-dashboard/addAccount")
    public String getAddAccount() {
        return "/admin-dashboard/addAccount";
    }
    @PostMapping("/admin-dashboard/addAccount")
    public String addAccount(
            @RequestParam long accountNo,
            @RequestParam int accountTypeId,
            @RequestParam String userId,
            @RequestParam String aadhaarNumber,
            @RequestParam String mobileNumber,
            @RequestParam String ifscCode,
            @RequestParam double balance,
            @RequestParam double creditLimit,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfCreation,
            Model model
    ) {
        try{
            Account account = adminService.addAccount(accountNo,accountTypeId,userId,aadhaarNumber,mobileNumber,ifscCode,balance,creditLimit,dateOfCreation,"");
            model.addAttribute("account",account);
            model.addAttribute("modalMessage", "Account successfully created!");
        } catch(DuplicateKeyException e){
            model.addAttribute(e.getMessage(),e.getMessage()+" already linked with account");
        }
        catch (FieldValueNotFoundException e) {
            if(!e.getFieldName().equals("userId")) {
                System.out.println(ifscCode);
                model.addAttribute(e.getFieldName(), e.getMessage());
            }
        }
        return "/admin-dashboard/addAccount";
    }
    @GetMapping("/admin-dashboard/addBranch")
    public String getAddBranch() {
        return "/admin-dashboard/addBranch";
    }

    @PostMapping("/admin-dashboard/addBranch")
    public String addBranch(
            @RequestParam String ifscCode,
            @RequestParam String branchName,
            @RequestParam String branchAddress,
            Model model
    ){
        try{
            Branch branch = adminService.addBranch(ifscCode,branchName,branchAddress);
            model.addAttribute("branch",branch);
            return "/admin-dashboard/home";
        }
        catch(DuplicateKeyException e){
            model.addAttribute(e.getMessage(),e.getMessage()+" already exists ");
        }
        return "/admin-dashboard/addBranch";
    }

    @GetMapping("/admin-dashboard/addAccountType")
    public String getAddAccountType() {
        return "/admin-dashboard/addAccountType";
    }

    @PostMapping("/admin-dashboard/addAccountType")
    public String addAccountType(
            @RequestParam int accountTypeId,
            @RequestParam String accountTypeName,
            @RequestParam double interestRate,
            @RequestParam double minimumBalance,
            @RequestParam double overdraftLimit,
            @RequestParam double withdrawalLimit,
            @RequestParam double depositLimit,
            @RequestParam boolean isMinorAccount,
            Model model
    ) {
       try{
           AccountType accountType = adminService.addAccountType(accountTypeId,accountTypeName,interestRate,minimumBalance,overdraftLimit,withdrawalLimit,depositLimit,isMinorAccount);
           model.addAttribute("accountType",accountType);
           System.out.println("successfull");
       }
       catch (DuplicateKeyException e){
           e.printStackTrace();
           model.addAttribute(e.getMessage(),e.getMessage()+" already exists ");
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "/admin-dashboard/home";
    }
}
