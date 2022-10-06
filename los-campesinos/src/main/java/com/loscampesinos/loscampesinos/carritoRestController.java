package com.loscampesinos.loscampesinos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loscampesinos.loscampesinos.controller.dto.ProductoDto;
import com.loscampesinos.loscampesinos.service.ProductoServie;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/producto")
public class carritoRestController {
    
    private ProductoServie productoServie;

    @GetMapping("/{id}") 
    public ResponseEntity<ProductoDto> getProductosById(@PathVariable("id") Integer idProducto) {
        var producto = productoServie.getProductosById(idProducto);
        return ResponseEntity.ok().body(producto);
    }
}
