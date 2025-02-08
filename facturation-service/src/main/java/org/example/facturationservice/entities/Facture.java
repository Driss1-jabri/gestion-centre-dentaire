package org.example.facturationservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private boolean finpaiement;
    private Long consultationId;
    @OneToMany(mappedBy = "facture")
    private List<Paiement> listPaiement = new ArrayList<>();

    private LocalDate date = LocalDate.now();

    // Getter and Setter for date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Transient
    private ConsultationRequest consultationRequest;

    public boolean isFinpaiement() {
        return finpaiement;
    }

    public void setFinpaiement(boolean finpaiement) {
        this.finpaiement = finpaiement;
    }

    public ConsultationRequest getConsultationRequest() {
        return consultationRequest;
    }

    public void setConsultationRequest(ConsultationRequest consultationRequest) {
        this.consultationRequest = consultationRequest;
    }

}