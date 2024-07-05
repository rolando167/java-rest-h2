package com.api.h2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.h2.Entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    List<Pedido> findByClienteId(Long clienteId);
}