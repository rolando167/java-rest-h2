package com.api.h2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.api.h2.Entities.Cliente;
import com.api.h2.Services.ClienteService;

public class ClienteTest {
    @Test
	public void getAll() {
        ClienteService clienteService = new ClienteService();
        List<Cliente> clientes = clienteService.getAll();

        assertNotNull(clientes);
        //assertEquals(10, result); // valor esperado, valor actual
        //assertInstanceOf(Integer.class, clienteService);
	}
}
