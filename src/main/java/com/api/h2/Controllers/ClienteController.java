package com.api.h2.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.api.h2.Dtos.ClienteView;
import com.api.h2.Entities.Cliente;
import com.api.h2.Services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        return new ResponseEntity<>(
                clientes,
                null,
                HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        Optional<Cliente> clientes = clienteService.find(id);

        if (clientes.isPresent()) {
            return new ResponseEntity<>(clientes.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/max")
    public ResponseEntity<?> maxAge() {
        Long maxAge = clienteService.maxAge();

        if (maxAge > 0) {
            return new ResponseEntity<>(maxAge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/min")
    public ResponseEntity<?> minAge() {
        Long minAge = clienteService.minAge();

        if (minAge > 0) {
            return new ResponseEntity<>(minAge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sum")
    public ResponseEntity<?> sumAge() {
        Long sumAge = clienteService.sumAge();

        if (sumAge > 0) {
            return new ResponseEntity<>(sumAge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> count() {
        Long total = clienteService.cantidad();

        if (total > 0) {
            return new ResponseEntity<>(total, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getListObjet")
    public ResponseEntity<?> getListObjet() {
        List<Object[]> listObjects = clienteService.getListObjet();
        System.out.println(listObjects);
        System.out.println("--------------------------");
        System.out.println(listObjects.stream());
        if (listObjects.size()> 0) {
            return new ResponseEntity<>(listObjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getListView")
    public ResponseEntity<?> getListView() {
       List<ClienteView> listObjects = clienteService.getListView();
        System.out.println(listObjects);
        System.out.println("--------------------------");
        System.out.println(listObjects.stream());
        if (listObjects.size()> 0) {
            return new ResponseEntity<>(listObjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getFindListView/{id}")
    public ResponseEntity<?> getFindListView(@PathVariable Long id) {
       List<ClienteView> listObjects = clienteService.getFindListView(id);
        System.out.println(listObjects);
        System.out.println("--------------------------");
        System.out.println(listObjects.stream());
        if (listObjects.size()> 0) {
            return new ResponseEntity<>(listObjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPage")
    public ResponseEntity<?> getPageObject(Pageable pageable) {
       Page<Object[]> listObjects = clienteService.getPageObject(pageable);
        System.out.println(listObjects);
        System.out.println("--------------------------");
        System.out.println(listObjects.stream());
        if (!listObjects.isEmpty()) {
            return new ResponseEntity<>(listObjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("create")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clientesaved = clienteService.save(cliente);

        return new ResponseEntity<>(
                clientesaved,
                HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteupdated = clienteService.update(cliente, id);

        return new ResponseEntity<>(
                clienteupdated,
                HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Cliente clienteDeleted = clienteService.delete(id);

            return new ResponseEntity<>(
                    clienteDeleted,
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
