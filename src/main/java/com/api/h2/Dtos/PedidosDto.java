package com.api.h2.Dtos;

import java.time.LocalDateTime;

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
    private LocalDateTime fecha_pedido;
    private ClienteDto cliente;
}
