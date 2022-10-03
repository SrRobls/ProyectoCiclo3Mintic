package com.loscampesinos.loscampesinos.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class usuario {
    private String nombre;
    @Id
    private String username;
    private String correo;
    private String contraseña;
    private Boolean active;
    private Boolean admin;
}
