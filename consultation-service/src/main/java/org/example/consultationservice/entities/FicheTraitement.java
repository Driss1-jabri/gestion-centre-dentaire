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
}
