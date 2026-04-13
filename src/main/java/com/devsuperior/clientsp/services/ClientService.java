package com.devsuperior.clientsp.services;

import com.devsuperior.clientsp.dto.ClientDTO;
import com.devsuperior.clientsp.entities.Client;
import com.devsuperior.clientsp.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).get();
        return modelMapper.map(client, ClientDTO.class);
    }
}
