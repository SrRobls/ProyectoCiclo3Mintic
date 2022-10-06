package com.loscampesinos.loscampesinos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
    private Integer idProducto;
    private String nombre;
    private Double precioKilo;
    private String linkImagen;
    private String id_Tipo;
}
