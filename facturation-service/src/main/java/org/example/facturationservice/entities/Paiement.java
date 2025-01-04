package org.example.facturationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paiments")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datePaiement;

    @Enumerated(EnumType.STRING)
    private MODEPAIEMENT modePaiement;

    private BigDecimal montant;
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
}
