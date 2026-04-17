package com.devsuperior.clientsp.services;

import com.devsuperior.clientsp.dto.ClientDTO;
import com.devsuperior.clientsp.entities.Client;
import com.devsuperior.clientsp.repositories.ClientRepository;
import com.devsuperior.clientsp.services.exceptions.DatabaseException;
import com.devsuperior.clientsp.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado."));
        return modelMapper.map(client, ClientDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(x -> modelMapper.map(x, ClientDTO.class));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        convertClientToDTO(client, dto);
        client = repository.save(client);
        return modelMapper.map(client, ClientDTO.class);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        Client client = repository.getReferenceById(id);
        convertClientToDTO(client, dto);
        client = repository.save(client);
        return modelMapper.map(client, ClientDTO.class);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
        try {
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial.");
        }
    }

    public void convertClientToDTO(Client client, ClientDTO dto){
        client.setName(dto.getName());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setCpf(dto.getCpf());
        client.setChildren(dto.getChildren());
    }
}
