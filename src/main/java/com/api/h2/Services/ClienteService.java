package com.api.h2.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.h2.Entities.Cliente;
import com.api.h2.Repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> find(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente, Long id){
        Optional<Cliente> clientefind = clienteRepository.findById(id);
        if (clientefind.isPresent()) {
            Cliente cliente2 = clientefind.get();
            cliente2.setName(cliente.getName());
            cliente2.setLast_name(cliente.getLast_name());
            return clienteRepository.save(cliente2);
        }
        else{
            return null;
        }
    }

    public Cliente delete(long id){
        Optional<Cliente> clientefind = clienteRepository.findById(id);
        if(clientefind.isPresent()) {
             clienteRepository.deleteById(id);
             return clientefind.get();
        }else{
            return null;
        }
    }
}
