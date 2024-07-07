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

    public Producto find(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return producto.get();
        }
        return new Producto();
    }

    public Producto save(Producto producto) {
        // Funciona al 99%
        /*
         * select * from ventas
         * select * from ventas_productos
         * select * from productos
         */
        // ventas
        Venta venta1 = new Venta();
        venta1.setDescription("Juan Perez");
        venta1.setFecha_pedido(LocalDateTime.now());

        Venta venta2 = new Venta();
        venta2.setDescription("Oscar Blancarte");
        venta2.setFecha_pedido(LocalDateTime.now());

        Venta venta3 = new Venta();
        venta3.setDescription("Arturo Martinez");
        venta3.setFecha_pedido(LocalDateTime.now());

        // Productos
        Producto producto1 = new Producto();
        producto1.setName("Cafe simple");
        producto1.setPrice(1.5);
        producto1.addVenta(venta1);
        producto1.addVenta(venta2);
        producto1.addVenta(venta3);

        Producto producto2 = new Producto();
        producto2.setName("Queso pasado");
        producto1.setPrice(6D);
        producto2.addVenta(venta1);
        producto2.addVenta(venta2);
        producto2.addVenta(venta3);

        return productoRepository.save(producto1);
    }

    public List<Producto> buscarPorNombre(final String nombre) {

        return productoRepository.listarProductoNombre(nombre);
    }

    public String greet() {
        return "Hello, World";
    }
}
