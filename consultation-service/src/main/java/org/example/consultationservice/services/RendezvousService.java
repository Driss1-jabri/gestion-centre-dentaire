package org.example.consultationservice.services;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.repository.Rendezvousrepository;
import org.example.consultationservice.entities.RendezVous;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RendezvousService {

    private final Rendezvousrepository rendezVousRepository;

    public RendezvousService(Rendezvousrepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    // CREATE
    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    // READ
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    // UPDATE
    public RendezVous updateRendezVous(Long id, RendezVous updatedRendezVous) {
        return rendezVousRepository.findById(id)
                .map(existingRendezVous -> {
                    existingRendezVous.setDate(updatedRendezVous.getDate());
                    existingRendezVous.setHeure(updatedRendezVous.getHeure());
                    existingRendezVous.setStatus(updatedRendezVous.getStatus());
                    existingRendezVous.setIdPatient(updatedRendezVous.getIdPatient());
                    existingRendezVous.setConsultation(updatedRendezVous.getConsultation());
                    return rendezVousRepository.save(existingRendezVous);
                })
                .orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé avec ID : " + id));
    }

    // DELETE
    public void deleteRendezVous(Long id) {
        if (!rendezVousRepository.existsById(id)) {
            throw new RuntimeException("Rendez-vous non trouvé avec ID : " + id);
        }
        rendezVousRepository.deleteById(id);
    }
}
