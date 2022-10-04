package com.loscampesinos.loscampesinos.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestLogin {
    private String username;
    private String password;
}
