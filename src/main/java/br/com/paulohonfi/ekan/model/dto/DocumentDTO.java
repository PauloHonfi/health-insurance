package br.com.paulohonfi.ekan.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DocumentDTO {

    private Long id;
    private String documentType;
    private String description;
    private LocalDate inclusionDate;
    private LocalDate updateDate;
}
