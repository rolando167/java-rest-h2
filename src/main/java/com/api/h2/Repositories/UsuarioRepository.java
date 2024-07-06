package com.api.h2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.h2.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    //@Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.id = (:id)")
    //public Usuario findByIdAndFetchRolesEagerly(@Param("id") Long id);
}
