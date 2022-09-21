package com.loscampesinos.loscampesinos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private String id_producto;
    private String nombre;
    private Double precioKilo;
    private String Descripcion;
    private String linkImagen;
    private String id_Tipo;
}
