package com.api.h2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.h2.Entities.Usuario;
import com.api.h2.Services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Usuario> listUsuarios = usuarioService.getAll();
        return new ResponseEntity<>(
                listUsuarios,
                null,
                HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Usuario usuario = usuarioService.find2(id);
        return new ResponseEntity<>(
                usuario,
                null,
                HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario pedidosaved = usuarioService.save(usuario);

        return new ResponseEntity<>(
                pedidosaved,
                HttpStatus.CREATED);
    }

    @PostMapping("create2")
    public ResponseEntity<Usuario> createUserClient(@RequestBody Usuario usuario) {
        Usuario pedidosaved = usuarioService.saveUserClient(usuario);

        return new ResponseEntity<>(
                pedidosaved,
                HttpStatus.CREATED);
    }

}
