package com.api.h2;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.api.h2.Controllers.ProductoController;
import com.api.h2.Entities.Producto;
import com.api.h2.Services.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    // In this case this is some dummy data
    private List<Producto> studentList = null;
    private Producto productOne = null;
    private String studentJsonString = null;
    final private String urlController = "/api/producto";

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        this.studentList = Arrays.asList(new Producto("cafe", 5D, 10), new Producto("Queso", 7D, 21));
        this.productOne = new Producto("cafe", 5D, 10);
        this.studentJsonString = new ObjectMapper().writeValueAsString(productOne);
    }

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        when(productoService.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get(urlController + "/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }

    @Test
    public void test_GetStudentByNameAndClass() throws Exception {
        when(productoService.getAll()).thenReturn(studentList);
        this.mockMvc.perform(get("/api/producto/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_GetProductById() throws Exception {
        when(productoService.find(eq(1L))).thenReturn(productOne);
        this.mockMvc
                .perform(get(urlController + "/find/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void test_AddProducto() throws JsonProcessingException, Exception {
        when(productoService.save(eq(productOne))).thenReturn(productOne);
        this.mockMvc
                .perform(post(urlController + "/create")
                        .content(new ObjectMapper().writeValueAsString(productOne))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
