package br.com.paulohonfi.ekan.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Beneficiary implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private LocalDate birthdate;
    
    @CreationTimestamp
    private LocalDate inclusionDate;

    @UpdateTimestamp
    private LocalDate updateDate;
}
