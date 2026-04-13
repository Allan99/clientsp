package com.devsuperior.clientsp.controllers;

import com.devsuperior.clientsp.entities.Client;
import com.devsuperior.clientsp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public Client test(){
        Client client = repository.findById(1L).get();
        return client;
    }
}
