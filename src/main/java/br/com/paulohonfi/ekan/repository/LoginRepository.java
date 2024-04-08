package br.com.paulohonfi.ekan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulohonfi.ekan.model.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
