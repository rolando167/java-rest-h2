package com.api.h2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.h2.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "Select * from productos a where name like %:fil%", nativeQuery = true)
    public abstract List<Producto> listarProductoNombre(@Param("fil") String nombre);
}