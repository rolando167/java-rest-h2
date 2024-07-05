package com.api.h2.Dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidosDto {
    private String description;
    private LocalDate fecha_pedido;
    private ClienteDto cliente;
}
