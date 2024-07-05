package com.api.h2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.h2.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    @Query(value = "EXEC REPORTS.SP_listarUsers", nativeQuery = true)
    List<Cliente> listarPedidos(@Param("page_id") Long page_id);
}
