package br.com.paulohonfi.ekan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.paulohonfi.ekan.model.entity.Beneficiary;
import br.com.paulohonfi.ekan.repository.BeneficiaryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeneficiaryService {

    private final BeneficiaryRepository repository;

    public List<Beneficiary> findAll() {
        return repository.findAll();
    }

    public Beneficiary findById(final Long id) {
        return repository.findById(id).get();
    }

    public Beneficiary create(final Beneficiary beneficiary) {
        return repository.save(beneficiary);
    }

    public Beneficiary update(final Beneficiary beneficiary) {
        final Beneficiary persisted = repository.findById(beneficiary.getId()).get();
        persisted.setBirthdate(beneficiary.getBirthdate());
        persisted.setName(beneficiary.getName());
        persisted.setPhone(beneficiary.getPhone());
        return repository.save(persisted);
    }

    public void delete(final Long id) {
        Beneficiary persisted = repository.findById(id).get();
        repository.delete(persisted);
    }
    
}
