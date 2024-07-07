package com.api.h2;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.api.h2.Controllers.ProductoController;
import com.api.h2.Entities.Producto;
import com.api.h2.Services.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    // In this case this is some dummy data
    private List<Producto> studentList = null;
    private Producto studentOne = null;

    private String urlController = "/api/producto";

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        when(productoService.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get(urlController+"/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }

    @Test
    public void test_GetStudentByNameAndClass() throws Exception {
        when(productoService.getAll()).thenReturn(studentList);
        this.mockMvc.perform(get("/api/producto/getall"))
        .andExpect(status().isOk());
    }

}
