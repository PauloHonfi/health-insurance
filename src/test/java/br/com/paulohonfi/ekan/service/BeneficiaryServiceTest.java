package br.com.paulohonfi.ekan.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.paulohonfi.ekan.model.entity.Beneficiary;
import br.com.paulohonfi.ekan.repository.BeneficiaryRepository;

public class BeneficiaryServiceTest {

    private BeneficiaryService service;

    private BeneficiaryRepository repository;

    private DocumentService documentService;

    private Beneficiary beneficiary;

    @BeforeEach
    public void init() {
        repository = Mockito.mock(BeneficiaryRepository.class);
        documentService = Mockito.mock(DocumentService.class);
        service = new BeneficiaryService(repository, documentService);
        beneficiary = Mockito.mock(Beneficiary.class);
    }

    @Test
    void testCreate() {
        when(repository.save(any())).thenReturn(beneficiary);
        service.create(beneficiary);
        assertNotNull(beneficiary);
    }

    @Test
    void testDelete() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(beneficiary));
        service.delete(1L);
        verify(repository, times(1)).delete(beneficiary);
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(List.of(beneficiary));
        List<Beneficiary> all = service.findAll();
        assertNotNull(all);
    }

    @Test
    void testFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(beneficiary));
        Beneficiary byId = service.findById(1L);
        assertNotNull(byId);
    }

    @Test
    void testUpdate() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(beneficiary));
        service.update(beneficiary);
        verify(repository, times(1)).save(beneficiary);
    }
}
