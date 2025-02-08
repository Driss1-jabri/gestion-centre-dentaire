package org.example.consultationservice.entities;


import java.math.BigDecimal;

public record ConsultationRequest(
        Long id,
        String motif,
        Long ordonnanceId,
        Long rendezVousId,
        BigDecimal montantTotal

) {
    public ConsultationRequest {
    }
}