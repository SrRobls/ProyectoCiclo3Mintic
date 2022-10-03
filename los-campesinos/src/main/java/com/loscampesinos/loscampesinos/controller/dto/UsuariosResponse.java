package com.loscampesinos.loscampesinos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuariosResponse {
    private String nombre;
    private String username;
    private String correo;
    private Boolean admin;
}
