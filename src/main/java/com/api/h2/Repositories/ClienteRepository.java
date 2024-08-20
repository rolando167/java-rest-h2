package com.api.h2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.h2.Dtos.ClienteDto;
import com.api.h2.Dtos.ClienteView;
import com.api.h2.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "EXEC REPORTS.SP_listarUsers", nativeQuery = true)
    List<Cliente> listarPedidos(@Param("page_id") Long page_id);

    @Query(value = "Select max(age) from clientes", nativeQuery = true)
    Long getMaxEdad();

    @Query(value = "Select min(age) from clientes", nativeQuery = true)
    Long getMinEdad();

    @Query(value = "Select SUM(age) from clientes", nativeQuery = true)
    Long getSumEdad();

    @Query(value = "Select count(*) from clientes", nativeQuery = true)
    Long getCantidad();

    @Query(value = "Select name, age from clientes", nativeQuery = true)
    List<Object[]> getListObjet();

    @Query(value = "Select name, age, address as direccion, number_phone from clientes", nativeQuery = true)
    List<ClienteView> getListView();


    @Query(value = "Select name, age, address as direccion, number_phone from clientes where id = :idCliente"
    , nativeQuery = true)
    List<ClienteView> getFindListView(@Param("idCliente") Long id);
}
