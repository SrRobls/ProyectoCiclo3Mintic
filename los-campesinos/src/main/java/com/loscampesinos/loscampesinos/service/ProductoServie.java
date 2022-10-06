package com.loscampesinos.loscampesinos.service;

import java.util.List;

import com.loscampesinos.loscampesinos.controller.dto.ProductoDto;

public interface ProductoServie {
    

    List<ProductoDto> getProductos();

    ProductoDto getProductosById(Integer idProducto);

    List<ProductoDto> getProductosPorTipo(String idTipo);

    
}
