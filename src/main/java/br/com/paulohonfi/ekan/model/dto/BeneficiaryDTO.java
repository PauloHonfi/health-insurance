package br.com.paulohonfi.ekan.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class BeneficiaryDTO {

    private Long id;
    private List<DocumentDTO> documents;
    private String name;
    private String phone;
    private LocalDate birthdate;
    private LocalDate inclusionDate;
    private LocalDate updateDate;
}
