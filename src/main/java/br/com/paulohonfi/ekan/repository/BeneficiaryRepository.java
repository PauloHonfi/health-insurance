package br.com.paulohonfi.ekan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulohonfi.ekan.model.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

}
