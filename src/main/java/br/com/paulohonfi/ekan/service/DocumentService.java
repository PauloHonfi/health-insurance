package br.com.paulohonfi.ekan.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.paulohonfi.ekan.model.entity.Beneficiary;
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
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Document> findByBeneficiary(final Beneficiary beneficiary) {
        return repository.findByBeneficiary(beneficiary);
    }

    public List<Document> findByBeneficiaryId(final Long id) {
        return repository.findByBeneficiaryId(id);
    }

    public List<Document> createAll(final List<Document> documents) {
        return repository.saveAll(documents);
    }

    public Document update(final Document document) {
        final Document persisted = repository.findById(document.getId()).orElseThrow(NoSuchElementException::new);
        persisted.setDescription(document.getDescription());
        persisted.setDocumentType(document.getDocumentType());
        persisted.setUpdateDate(LocalDate.now());
        return repository.save(persisted);
    }

    public void delete(final Long id) {
        Document persisted = repository.findById(id).get();
        repository.delete(persisted);
    }

    public void deleteAll(final List<Document> documents) {
        repository.deleteAll(documents);
    }
}
