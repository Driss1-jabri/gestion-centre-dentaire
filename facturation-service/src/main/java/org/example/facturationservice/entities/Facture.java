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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public BigDecimal getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }

    public List<Paiement> getListPaiement() {
        return listPaiement;
    }

    public void setListPaiement(List<Paiement> listPaiement) {
        this.listPaiement = listPaiement;
    }

    private BigDecimal montantTotal = BigDecimal.ZERO;
    private BigDecimal montantPaye = BigDecimal.ZERO;
    private Long consultationId;
    @OneToMany(mappedBy = "facture")
    private List<Paiement> listPaiement = new ArrayList<>();

    private Long patientId;
    @Transient
    private Patient patient;

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