package com.test.task.junior.smallbank.web;

import java.util.Map;

import com.test.task.junior.smallbank.entity.Transaction;
import com.test.task.junior.smallbank.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/index")
    public String listTransactions(Map<String, Object> map) {

//        map.put("transaction", new Transaction());
        map.put("transactionList", transactionService.getAllTransactions());

        return "transactionList";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTransaction(@ModelAttribute("transaction") Transaction transaction,
                            BindingResult result) {

        transactionService.addTransaction(transaction);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{transactionId}")
    public String deleteTransaction(@PathVariable("transactionId") Integer transactionId) {

        transactionService.deleteTransaction(transactionId);

        return "redirect:/index";
    }

}
