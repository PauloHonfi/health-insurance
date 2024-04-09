package br.com.paulohonfi.ekan.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.ekan.model.entity.Login;
import br.com.paulohonfi.ekan.service.TokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final TokenService tokenService;

    private final AuthenticationManager authentication;

    @PostMapping
    public String login(@RequestBody Login login) {
        final UsernamePasswordAuthenticationToken token = 
            new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        Authentication authenticate = authentication.authenticate(token);

        Login user = (Login) authenticate.getPrincipal();
        
        return tokenService.generateToken(user);
    }

}
