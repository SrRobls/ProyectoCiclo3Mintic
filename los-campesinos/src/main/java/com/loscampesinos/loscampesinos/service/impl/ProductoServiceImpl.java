package com.loscampesinos.loscampesinos.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loscampesinos.loscampesinos.controller.dto.ProductoDto;
import com.loscampesinos.loscampesinos.model.repository.ProductoRepository;
import com.loscampesinos.loscampesinos.service.ProductoServie;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoServie{

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDto> getProductos() {
        var productos = productoRepository.findAll().stream()
            .map(prod -> new ProductoDto(prod.getId_producto(), prod.getNombre(), prod.getPrecioKilo(), prod.getLinkImagen(), prod.getTipo()))
            .collect(Collectors.toList());
        return productos;
    }

    @Override
    public List<ProductoDto> getProductosPorTipo(String idTipo) {
        // List<ProductoDto> productosTipo = Arrays.asList();
        // productosTipo = productos.stream()
        //     .filter(p -> p.getId_Tipo() == idTipo)
        //     .collect(Collectors.toList());

        // List<ProductoDto> productosTipo = productoRepository.findProductByTipo(idTipo).stream()
        //     .map(prod -> new ProductoDto(prod.getId_producto(), prod.getNombre(), prod.getPrecioKilo(), prod.getLinkImagen(), prod.getId_Tipo()))
        //     .collect(Collectors.toList());

        var productosTipo = productoRepository.findAllByTipo(idTipo).stream()
            .map(prod -> new ProductoDto(prod.getId_producto(), prod.getNombre(), prod.getPrecioKilo(), prod.getLinkImagen(), prod.getTipo()))
            .collect(Collectors.toList());
        return productosTipo;
    }

    @Override
    public ProductoDto getProductosById(Integer idProducto) {
        var produtOBj = productoRepository.findById(idProducto);

        var producto = produtOBj.get();
        return ProductoDto.builder()
                .idProducto(producto.getId_producto())
                .nombre(producto.getNombre())
                .precioKilo(producto.getPrecioKilo())
                .linkImagen(producto.getLinkImagen())
                .id_Tipo(producto.getTipo())
            .build();
    }
    
}
