package com.loscampesinos.loscampesinos.model.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class usuario {
    private Integer id_usuario;
    private String nombre;
    private String username;
    private String correo;
    private String contraseña;
    private Boolean active;
    private Boolean admin;
}
