package org.example.consultationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="Traitments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FicheTraitement {
    @Id
    private Long id;
    private String nomdent;
    private BigDecimal montant;
    private String description;
    private Long consultationId;
}
