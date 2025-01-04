package org.example.paiementservice.entities;

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
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime datePaient;
    private BigDecimal montant;
    private Long facture;

}
