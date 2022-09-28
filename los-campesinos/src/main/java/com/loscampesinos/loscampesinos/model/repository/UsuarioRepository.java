package com.loscampesinos.loscampesinos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loscampesinos.loscampesinos.model.entity.usuario;

public interface UsuarioRepository extends JpaRepository<usuario, Integer>{
    
}
