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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.h2.Entities.Producto;
import com.api.h2.Services.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return productoService.greet();
	}

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Producto> productos = productoService.getAll();
        return new ResponseEntity<>(
                productos,
                null,
                HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Producto producto = productoService.find(id);
        return new ResponseEntity<>(
                producto,
                null,
                HttpStatus.OK);
    }

    @GetMapping("/findnombre1/{nombre}")
    public ResponseEntity<?> findByNombre1(@PathVariable String productName) {
        List<Producto> productos = productoService.buscarPorNombre(productName);
        return new ResponseEntity<>(
                productos,
                null,
                HttpStatus.OK);
    }

    @GetMapping("/findnombre2")
    public ResponseEntity<?> findByNombre2(@RequestParam(name = "nombre") String productName) {
        // http://localhost:8080/api/producto/findnombre2?nombre=Queso
        // http://localhost:8080/api/producto/findnombre2?nombre=Queso&marca=Nestle
        List<Producto> productos = productoService.buscarPorNombre(productName);

        return new ResponseEntity<>(
                productos,
                null,
                HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        Producto pedidosaved = productoService.save(producto);

        return new ResponseEntity<>(
                pedidosaved,
                HttpStatus.CREATED);
    }
}
