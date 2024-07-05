package com.api.h2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.h2.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}