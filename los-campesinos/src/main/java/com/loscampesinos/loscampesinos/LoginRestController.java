package com.loscampesinos.loscampesinos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loscampesinos.loscampesinos.controller.dto.RequestLogin;
import com.loscampesinos.loscampesinos.service.impl.SegurityServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/index")
public class LoginRestController {
    

    private final SegurityServiceImpl segurityServiceImpl;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody RequestLogin user){
        

        try{
            var response = segurityServiceImpl.validarUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    };
}
