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
        final Login login = new Login();
        login.setUsername("paulo@ekan.com.br");
        login.setPassword("$2a$10$JgcK3lym6xK2qELud4sKce8lLd.9RCVNTPHaZi.mizyj1qNuhEnWm");
        repository.save(login);
    }

}
