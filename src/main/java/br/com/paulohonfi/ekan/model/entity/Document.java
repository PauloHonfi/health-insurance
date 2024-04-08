package br.com.paulohonfi.ekan.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Document implements Serializable {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Beneficiary beneficiary;

    private String documentType;
    private String description;

    @CreationTimestamp
    private LocalDate inclusionDate;

    @UpdateTimestamp
    private LocalDate updateDate;
}
