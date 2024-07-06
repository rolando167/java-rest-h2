package com.api.h2.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.h2.Entities.Producto;
import com.api.h2.Entities.Venta;
import com.api.h2.Repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> find(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {

        // ventas
        Venta venta1 = new Venta();
        venta1.setDescription("Juan Perez");
        venta1.setFecha_pedido(LocalDateTime.now());

        Venta venta2 = new Venta();
        venta2.setDescription("Oscar Blancarte");
        venta2.setFecha_pedido(LocalDateTime.now());

        Venta venta3 = new Venta();
        venta3.setDescription("Arturo Martinez");
        venta2.setFecha_pedido(LocalDateTime.now());

        // Productos
        Producto producto1 = new Producto();
        producto1.setName("Cafe simple");
        producto1.addVenta(venta1);
        producto1.addVenta(venta2);
        producto1.addVenta(venta3);

        Producto producto2 = new Producto();
        producto2.setName("Queso pasado");
        producto2.addVenta(venta1);
        producto2.addVenta(venta2);
        producto2.addVenta(venta3);

        return productoRepository.save(producto1);
    }
}
