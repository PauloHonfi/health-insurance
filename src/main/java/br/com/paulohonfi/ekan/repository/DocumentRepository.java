package br.com.paulohonfi.ekan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulohonfi.ekan.model.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>  {

}
