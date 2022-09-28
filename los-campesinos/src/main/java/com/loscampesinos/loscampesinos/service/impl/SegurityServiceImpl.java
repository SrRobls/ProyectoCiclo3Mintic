package com.loscampesinos.loscampesinos.service.impl;


import com.loscampesinos.loscampesinos.model.entity.usuario;
import com.loscampesinos.loscampesinos.model.repository.UsuarioRepository;
import com.loscampesinos.loscampesinos.service.SegurityService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SegurityServiceImpl implements SegurityService{
    
    private final UsuarioRepository usuarioRepository;
    
    @Override
    public usuario validarUser(String username, String password) {
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
        
        return user;
    }
    
    
    
}
