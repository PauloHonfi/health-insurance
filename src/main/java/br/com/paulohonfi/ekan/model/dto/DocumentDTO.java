package br.com.paulohonfi.ekan.model.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.paulohonfi.ekan.model.entity.Beneficiary;
import lombok.Data;

@Data
public class DocumentDTO {

    private Long id;
    private List<Beneficiary> beneficiaries;
    private String documentType;
    private String description;
    private LocalDate inclusionDate;
    private LocalDate updateDate;
}
