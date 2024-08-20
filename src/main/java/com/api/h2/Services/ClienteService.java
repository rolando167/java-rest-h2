package com.api.h2.Services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.h2.Entities.Cliente;
import com.api.h2.Repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> find(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        Random rand = new Random();
        int max = 50;
        int min = 20;
        Integer rand_int1 = rand.nextInt(max - min + 1) + min;
        cliente.setAge(rand_int1.longValue());
        return clienteRepository.save(cliente);
    }

    public Long maxAge() {
        return clienteRepository.getMaxEdad();
    }

    public Long minAge() {
        return clienteRepository.getMinEdad();
    }

    public Long sumAge() {
        return clienteRepository.getSumEdad();
    }

    public Long cantidad() {
        return clienteRepository.getCantidad();
    }

    public Cliente update(Cliente cliente, Long id) {
        Optional<Cliente> clientefind = clienteRepository.findById(id);
        if (clientefind.isPresent()) {
            Cliente cliente2 = clientefind.get();
            cliente2.setName(cliente.getName());
            cliente2.setLast_name(cliente.getLast_name());
            return clienteRepository.save(cliente2);
        } else {
            return null;
        }
    }

    public Cliente delete(long id) {
        Optional<Cliente> clientefind = clienteRepository.findById(id);
        if (clientefind.isPresent()) {
            clienteRepository.deleteById(id);
            return clientefind.get();
        } else {
            return null;
        }
    }
}
