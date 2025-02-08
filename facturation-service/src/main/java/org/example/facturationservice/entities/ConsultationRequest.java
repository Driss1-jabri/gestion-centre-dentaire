package org.example.facturationservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

public class ConsultationRequest {
    private Long id;
    private String motif;

    private Long rendezVousId;

    public ConsultationRequest(Long id, String motif, Long rendezVousId, BigDecimal montantTotal) {
        this.id = id;
        this.motif = motif;
        this.rendezVousId = rendezVousId;
        this.montantTotal = montantTotal;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public Long getRendezVousId() {
        return rendezVousId;
    }

    public void setRendezVousId(Long rendezVousId) {
        this.rendezVousId = rendezVousId;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    private BigDecimal montantTotal;

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Long getId() {
        return id;
    }
}
