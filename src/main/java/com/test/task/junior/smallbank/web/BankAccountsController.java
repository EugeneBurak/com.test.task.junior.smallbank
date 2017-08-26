package com.test.task.junior.smallbank.web;

import java.util.Map;

import com.test.task.junior.smallbank.entity.BankAccount;
import com.test.task.junior.smallbank.services.BankAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BankAccountsController {

    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping("/index")
    public String listBankAccount(Map<String, Object> map) {

//        map.put("bankAccount", new BankAccount());
        map.put("bankAccountList", bankAccountService.getAllBankAccounts());

        return "bankAccountList";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBankAccount(@ModelAttribute("bankAccount") BankAccount bankAccount,
                            BindingResult result) {

        bankAccountService.addBankAccount(bankAccount);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{bankAccountId}")
    public String deleteBankAccount(@PathVariable("bankAccountId") Integer bankAccountId) {

        bankAccountService.deleteBankAccount(bankAccountId);

        return "redirect:/index";
    }

}
