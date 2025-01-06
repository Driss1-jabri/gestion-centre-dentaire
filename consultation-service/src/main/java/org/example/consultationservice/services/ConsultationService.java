package org.example.consultationservice.services;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.entities.Consultation;
import org.example.consultationservice.entities.RendezVous;
import org.example.consultationservice.repository.ConsultationRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final RendezvousService rdService;
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
    public Consultation updateConsultation(Long id, Consultation updatedConsultation ) {
        RendezVous rd= rdService.getRendezVousById(updatedConsultation.getRendezVous().getId()).orElseThrow(
                ()-> new RuntimeException("vous n'etes pas en rendez vous")
        );
        return consultationRepository.findById(id)
                .map(existingConsultation -> {
                    existingConsultation.setMotif(updatedConsultation.getMotif());
                    existingConsultation.setOrdonnance(updatedConsultation.getOrdonnance());
                    existingConsultation.setRendezVous(rd);
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

    public ConsultationService(ConsultationRepository consultationRepository,
                               RendezvousService rdService) {
        this.consultationRepository = consultationRepository;
        this.rdService=rdService;
    }
}
