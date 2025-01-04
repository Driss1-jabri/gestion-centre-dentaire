package org.example.facturationservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Facture")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private BigDecimal montantTotal = BigDecimal.ZERO;
    private BigDecimal montantPaye = BigDecimal.ZERO;
    private Long consultationId;
    @OneToMany(mappedBy = "facture")
    private List<Paiement> listPaiement = new ArrayList<>();

    public void addPaiement(Paiement paiement) {
        if (paiement != null) {
            paiement.setFacture(this);
            this.listPaiement.add(paiement);
            if (paiement.getMontant() != null) {
                this.montantPaye = this.montantPaye.add(paiement.getMontant());
            }
        }
    }
}
