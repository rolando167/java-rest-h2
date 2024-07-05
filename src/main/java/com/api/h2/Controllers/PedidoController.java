package com.api.h2.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.h2.Dtos.PedidosDto;
import com.api.h2.Entities.Pedido;
import com.api.h2.Services.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Pedido> pedidos = pedidoService.getAll();
        return new ResponseEntity<>(
                pedidos,
                null,
                HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        // Obtener un pedido con su cliente respectio usando DTO
        PedidosDto pedidosDto = pedidoService.find(id);
        return new ResponseEntity<>(pedidosDto, HttpStatus.OK);
    }

    @GetMapping("/find/{id}/clientes")
    public ResponseEntity<?> getAllPedidosByClienteId(@PathVariable Long id) {
        // OBTENER TODOS LOS PEDIDOS DE UN CLIENTE
        List<Pedido> pedidos = pedidoService.getAllPedidosByClienteId(id);
        return new ResponseEntity<>(
                pedidos,
                null,
                HttpStatus.OK);
    }

    @PostMapping("create/{cliente_id}")
    public ResponseEntity<Pedido> create(@PathVariable(value = "cliente_id") Long cliente_id,
            @RequestBody Pedido pedido) {
        // guardar many to one
        pedido.setFecha_pedido(LocalDate.now());
        Pedido pedidosaved = pedidoService.save(cliente_id, pedido);

        return new ResponseEntity<>(
                pedidosaved,
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id") long id, @RequestBody Pedido pedido) {
        Pedido pedidoUpdated = pedidoService.update(id, pedido);
        return new ResponseEntity<>(pedidoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        pedidoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
