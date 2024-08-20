package com.api.h2.Services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.h2.Dtos.ClienteView;
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
        Integer rand_age = getNumberRandom(20, 50);
        Integer rand_coche = getNumberRandom(1, 2);
        cliente.setAge(rand_age.longValue());
        if (rand_coche % 2 == 0) {
            cliente.setCoche(true);
        }else{
            cliente.setCoche(false);
        }
        return clienteRepository.save(cliente);
    }

    private int getNumberRandom(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
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

    public List<Object[]> getListObjet() {
        return clienteRepository.getListObject();
    }

    public List<ClienteView> getListView() {
        return clienteRepository.getListView();
    }

    public List<ClienteView> getFindListView(Long id) {
        return clienteRepository.getFindListView(id);
    }

    public Page<Object[]> getPageObject(Pageable pageable) {
        return clienteRepository.getPageObject(pageable);
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
