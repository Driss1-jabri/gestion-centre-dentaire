package org.example.consultationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Table(name = "traitements")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FicheTraitement {
    @Id
    private Long id;
    private String nomDent; // Correction du nom
    private BigDecimal montant;
    private String description;
    @ManyToOne
    @JoinColumn(name = "consultation_id", nullable = false)
    private Consultation consultation;

    public FicheTraitement(Long id, String nomDent, BigDecimal montant, String description, Consultation consultation) {
        this.id = id;
        this.nomDent = nomDent;
        this.montant = montant;
        this.description = description;
        this.consultation = consultation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomDent() {
        return nomDent;
    }

    public void setNomDent(String nomDent) {
        this.nomDent = nomDent;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
