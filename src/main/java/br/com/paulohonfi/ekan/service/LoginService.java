package br.com.paulohonfi.ekan.service;

import org.springframework.stereotype.Service;

import br.com.paulohonfi.ekan.repository.LoginRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository repository;

    public Boolean existsByEmailAndPassword(final String email, final String password) {
        return repository.existsByEmailAndPassword(email, password);
    }
}
