package br.com.paulohonfi.ekan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.ekan.model.entity.Login;
import br.com.paulohonfi.ekan.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;

    @PostMapping
    public String login(@RequestBody Login login) {
        return service.existsByEmailAndPassword(login.getEmail(), login.getPassword()).toString();
    }
    
}
