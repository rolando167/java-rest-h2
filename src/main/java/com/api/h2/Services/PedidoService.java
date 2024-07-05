package com.api.h2.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.h2.Dtos.ClienteDto;
import com.api.h2.Dtos.PedidosDto;
import com.api.h2.Entities.Cliente;
import com.api.h2.Entities.Pedido;
import com.api.h2.Repositories.ClienteRepository;
import com.api.h2.Repositories.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public PedidosDto find(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if (pedido.isPresent()) {
            PedidosDto pedidosDto = new PedidosDto();
            Pedido ped = pedido.get();
            Optional<Cliente> cliente = clienteRepository.findById(ped.getCliente().getId());
            pedidosDto.setDescription(ped.getDescription());
            pedidosDto.setFecha_pedido(LocalDate.now());
            if (cliente.isPresent()) {
                Cliente cli = cliente.get();
                ClienteDto clienteDto = new ClienteDto();
                clienteDto.setName(cli.getName());
                pedidosDto.setCliente(clienteDto);
            }
            return pedidosDto;
        }

        return null;
    }

    public List<Pedido> getAllPedidosByClienteId(Long id) {
        List<Pedido> pedidos = pedidoRepository.findByClienteId(id);
        return pedidos;
    }

    public Pedido save(long cliente_id, Pedido pedido) {
        Optional<Cliente> cliente = clienteRepository.findById(cliente_id);
        if (cliente.isPresent()) {
            pedido.setCliente(cliente.get());
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public Pedido update(long id, Pedido pedido) {
        Optional<Pedido> pedidoNew = pedidoRepository.findById(id);
        if(pedidoNew.isPresent()){
            Pedido pedidoUpd = pedidoNew.get();
            pedidoUpd.setDescription(pedido.getDescription());
            pedidoUpd.setFecha_pedido(LocalDate.now());
            pedidoRepository.save(pedidoUpd);
            return pedidoUpd;
        }
        return null;
    }

    public void deleteById(long id){
        pedidoRepository.deleteById(id);
    }
}
