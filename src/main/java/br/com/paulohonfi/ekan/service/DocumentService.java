package br.com.paulohonfi.ekan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.paulohonfi.ekan.model.entity.Document;
import br.com.paulohonfi.ekan.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    public List<Document> findAll() {
        return repository.findAll();
    }

    public Document findById(final Long id) {
        return repository.findById(id).get();
    }

    public Document create(final Document document) {
        return repository.save(document);
    }

    public Document update(final Document document) {
        final Document persisted = repository.findById(document.getId()).get();
        persisted.setBeneficiaries(document.getBeneficiaries());
        persisted.setDescription(document.getDescription());
        persisted.setDocumentType(document.getDocumentType());
        persisted.setUpdateDate(LocalDate.now());
        return repository.save(persisted);
    }

    public void delete(final Long id) {
        Document persisted = repository.findById(id).get();
        repository.delete(persisted);
    }
}
