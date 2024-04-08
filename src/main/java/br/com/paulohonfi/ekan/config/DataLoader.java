package br.com.paulohonfi.ekan.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.paulohonfi.ekan.model.entity.Login;
import br.com.paulohonfi.ekan.repository.LoginRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final LoginRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Login("paulo@ekan.com.br", "1234"));
    }

}
