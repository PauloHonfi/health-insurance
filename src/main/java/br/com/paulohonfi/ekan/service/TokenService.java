package br.com.paulohonfi.ekan.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.paulohonfi.ekan.model.entity.Login;

@Service
public class TokenService {

    public String generateToken(final Login user) {
        return JWT.create()
                    .withIssuer("Beneficiary")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(LocalDateTime.now()
                            .plusMinutes(10)
                            .toInstant(ZoneOffset.of("-03:00")))
                    .sign(Algorithm.HMAC256("EKAN"));
    }

    public String getSubject(final String token) {
        return JWT.require(Algorithm.HMAC256("EKAN"))
        .withIssuer("Beneficiary")
        .build()
        .verify(token).getSubject();
    }
}
