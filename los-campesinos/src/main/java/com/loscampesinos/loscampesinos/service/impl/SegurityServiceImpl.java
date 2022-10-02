package com.loscampesinos.loscampesinos.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loscampesinos.loscampesinos.controller.dto.UsuariosRequest;
import com.loscampesinos.loscampesinos.controller.dto.UsuariosResponse;
import com.loscampesinos.loscampesinos.model.entity.usuario;
import com.loscampesinos.loscampesinos.model.repository.UsuarioRepository;
import com.loscampesinos.loscampesinos.service.SegurityService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Service
public class SegurityServiceImpl implements SegurityService{
    
    private final UsuarioRepository usuarioRepository;
    
    @Override
    public UsuariosResponse validarUser(String username, String password) {
        var userOp = usuarioRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("Usuario No Existente");
        }

        var user = userOp.get();
        if(!user.getActive()){
            throw new RuntimeException("Usuario Inactivo");
        }

        if (!user.getContraseña().equals(password)){
            throw new RuntimeException("Contraseña Incorrecta");
        }
        
        return UsuariosResponse.builder()
        .username(user.getUsername())
        .nombre(user.getNombre())
        .correo(user.getCorreo())
        .admin(user.getAdmin())
        .build();
    }

    @Override
    public void crearUsuario(UsuariosRequest usuario) {
        var userOp = usuarioRepository.findById(usuario.getUsername());

        if(userOp.isPresent()){
            throw new RuntimeException("El Usuario Ya Existe");
        }

        var userDb = new usuario();
        userDb.setUsername(usuario.getUsername());
        userDb.setContraseña(usuario.getPassword());
        userDb.setNombre(usuario.getNombre());
        userDb.setCorreo(usuario.getCorreo());
        userDb.setActive(true);
        userDb.setAdmin(usuario.getAdmin());
        userDb = usuarioRepository.save(userDb);
        
    }

    @Override
    public void updateUsuario(UsuariosRequest usuario) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteUsuario(String username) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void activarUsuario(String username) {
        var userOp = usuarioRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get();
        user.setActive(true);
        usuarioRepository.save(user);
        
    }

    @Override
    public void inactivarUsuario(String username) {
        var userOp = usuarioRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        var user = userOp.get();
        user.setActive(false);
        usuarioRepository.save(user);
        
    }

    @Override
    public List<UsuariosResponse> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
            .map(u -> UsuariosResponse.builder()
                .username(u.getUsername())
                .nombre(u.getNombre())
                .correo(u.getCorreo())
                .admin(u.getAdmin())
                .build())
            .collect(Collectors.toList());
    }

    @Override
    public UsuariosResponse getUsuarioByUsername(String username) {
        var userOp = usuarioRepository.findById(username);
        if (userOp.isEmpty()){
            throw new RuntimeException("El usuario no esxite");
        }

        var user = userOp.get();
        return UsuariosResponse.builder()
        .username(user.getUsername())
        .nombre(user.getNombre())
        .correo(user.getCorreo())
        .admin(user.getAdmin())
        .build();
    }
    
    
    
}
