package com.api.h2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import com.api.h2.Controllers.ProductoController;

@SpringBootTest
public class ProductoControllerTest2 {
    @Autowired
    private ProductoController productoController;

    @Test
	void contextLoads() throws Exception {
		assertThat(productoController).isNotNull();
	}
}
