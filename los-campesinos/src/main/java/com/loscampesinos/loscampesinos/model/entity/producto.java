package com.loscampesinos.loscampesinos.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity; //JPA
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.DocFlavor.STRING;

import lombok.Data;

@Entity // para indicarle que es una tabla en la base de datos
@Data // me genera por defecto los setter y getter
@Table(name = "Productos") //colocarle el nombre a la tabla
public class producto {
    @Id //para indicar a llaver primaria de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO) // PARA INDICARLE QUE EL AVLOR SE GENERE POR SI SOLO DE MANERA INCREMENTAL
    private Integer id_producto;

    @Column(name = "Nombre", nullable = false, length = 50) // para indicarle caracteristicas al campo nombre de la tabla
    private String nombre;
    private Double precioKilo;
    private String linkImagen;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    // en id tipo es 1 para verduras, 2 para frutas y 3 para granos.
}
