package org.example.consultationservice.entities;




public record ConsultationRequest(
        Long id,
        String motif,
        Long ordonnanceId,
        Long rendezVousId
) {
    public ConsultationRequest {
    }
}