package com.api.h2.Services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.h2.Entities.Cliente;
import com.api.h2.Entities.Usuario;
import com.api.h2.Repositories.ClienteRepository;
import com.api.h2.Repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Usuario> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario find(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Optional<Cliente> cliente = clienteRepository.findById(id);

            if (cliente.isPresent()) {
                usuario.get().setCliente(cliente.get());
            }
            return usuario.get();
        }
        return new Usuario();
    }

    public Usuario find2(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Optional<Cliente> cliente = clienteRepository.findById(id);

            if (cliente.isPresent()) {
                usuario.get().setCliente(cliente.get());
            }
            return usuario.get();
        }
        return new Usuario();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario saveUserClient(Usuario usuario) {
        // SAVE: usuario y cliente ONE TO ONE
        Random rand = new Random();
        int rand_int1 = rand.nextInt(200);
        //double rand_dub1 = rand.nextDouble();

        Cliente cliente = new Cliente();
        cliente.setName(usuario.getName());
        cliente.setLast_name(rand_int1+"-" + usuario.getName());
        cliente.setUsuario(usuario);
        clienteRepository.save(cliente);
        return usuario;
    }
}
