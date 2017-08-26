package com.test.task.junior.smallbank.web;

import java.util.Map;

import com.test.task.junior.smallbank.entity.Client;
import com.test.task.junior.smallbank.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/index")
    public String listClients(Map<String, Object> map) {

//        map.put("client", new Client());
        map.put("clientList", clientService.getAllClients());

        return "clientList";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client,
                             BindingResult result) {

        clientService.addClient(client);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteClient(@PathVariable("clientId") Integer clientId) {

        clientService.deleteClient(clientId);

        return "redirect:/index";
    }
}
