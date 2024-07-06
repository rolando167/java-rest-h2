package com.api.h2.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.h2.Entities.Producto;
import com.api.h2.Repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public Optional<Producto> find(Long id){
        return productoRepository.findById(id);
    }

    public Producto save(Producto usuario){
        return productoRepository.save(usuario);
    }
}

