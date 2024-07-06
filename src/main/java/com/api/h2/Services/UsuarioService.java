package com.api.h2.Services;

import java.util.List;
import java.util.Optional;

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

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario find(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            Optional<Cliente> cliente = clienteRepository.findById(id);

            if(cliente.isPresent()){
                usuario.get().setCliente(cliente.get());
            }
            return usuario.get();
        }
        return new Usuario();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario saveUserClient(Usuario usuario){

        Cliente cliente = new Cliente();
        cliente.setName(usuario.getName());
        cliente.setLast_name("last "+ usuario.getName());
        usuario.setCliente(cliente);

        return usuarioRepository.save(usuario);
    }
}
