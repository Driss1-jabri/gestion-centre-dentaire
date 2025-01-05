package org.example.consultationservice.services;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.entities.Consultation;
import org.example.consultationservice.repository.ConsultationRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    // CREATE
    public Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    // READ
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    // UPDATE
    public Consultation updateConsultation(Long id, Consultation updatedConsultation) {
        return consultationRepository.findById(id)
                .map(existingConsultation -> {
                    existingConsultation.setMotif(updatedConsultation.getMotif());
                    existingConsultation.setOrdonnance(updatedConsultation.getOrdonnance());
                    existingConsultation.setRendezVous(updatedConsultation.getRendezVous());
                    existingConsultation.setFichesDeTraitement(updatedConsultation.getFichesDeTraitement());
                    return consultationRepository.save(existingConsultation);
                })
                .orElseThrow(() -> new RuntimeException("Consultation non trouvée avec ID : " + id));
    }

    // DELETE
    public void deleteConsultation(Long id) {
        if (!consultationRepository.existsById(id)) {
            throw new RuntimeException("Consultation non trouvée avec ID : " + id);
        }
        consultationRepository.deleteById(id);
    }

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }
}
