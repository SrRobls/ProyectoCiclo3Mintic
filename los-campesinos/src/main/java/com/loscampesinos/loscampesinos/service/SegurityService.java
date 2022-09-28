package com.loscampesinos.loscampesinos.service;

import org.springframework.stereotype.Service;

import com.loscampesinos.loscampesinos.model.entity.usuario;

@Service
public interface SegurityService {

    public usuario validarUser(String username, String password);
}
