package com.loscampesinos.loscampesinos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuariosRequest {
    private String nombre;
    private String username;
    private String password;
    private String correo;
    // private Boolean admin;
}
