package br.com.paulohonfi.ekan.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Beneficiary implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "beneficiary")
    private List<Document> documents;

    private String name;
    private String phone;
    private LocalDate birthdate;
    
    @CreationTimestamp
    private LocalDate inclusionDate;

    @UpdateTimestamp
    private LocalDate updateDate;
}
