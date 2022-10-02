package com.loscampesinos.loscampesinos.service;

import java.util.List;


import com.loscampesinos.loscampesinos.controller.dto.UsuariosRequest;
import com.loscampesinos.loscampesinos.controller.dto.UsuariosResponse;


public interface SegurityService {

    public UsuariosResponse validarUser(String username, String password);

    void crearUsuario(UsuariosRequest usuario);

    void updateUsuario(UsuariosRequest usuario);

    void deleteUsuario(String username);

    void activarUsuario(String username);

    void inactivarUsuario(String username);

    List<UsuariosResponse> getAllUsuarios();

    UsuariosResponse getUsuarioByUsername(String username);
}
