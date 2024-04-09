package br.com.paulohonfi.ekan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulohonfi.ekan.model.entity.Beneficiary;
import br.com.paulohonfi.ekan.model.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>  {

    public List<Document> findByBeneficiary(final Beneficiary beneficiary);

    public List<Document> findByBeneficiaryId(final Long id);
}
