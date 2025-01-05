package org.example.consultationservice.services;

import org.example.consultationservice.entities.Ordonnance;
import org.example.consultationservice.repository.OrdonnanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdonnanceService {

    private final OrdonnanceRepository ordonnanceRepository;

    public OrdonnanceService(OrdonnanceRepository ordonnanceRepository) {
        this.ordonnanceRepository = ordonnanceRepository;
    }

    // CREATE
    public Ordonnance createOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    // READ
    public List<Ordonnance> getAllOrdonnances() {
        return ordonnanceRepository.findAll();
    }

    public Optional<Ordonnance> getOrdonnanceById(Long id) {
        return ordonnanceRepository.findById(id);
    }

    // UPDATE
    public Ordonnance updateOrdonnance(Long id, Ordonnance updatedOrdonnance) {
        return ordonnanceRepository.findById(id)
                .map(existingOrdonnance -> {
                    existingOrdonnance.setDescription(updatedOrdonnance.getDescription());
                    return ordonnanceRepository.save(existingOrdonnance);
                })
                .orElseThrow(() -> new RuntimeException("Ordonnance non trouvée avec ID : " + id));
    }

    // DELETE
    public void deleteOrdonnance(Long id) {
        if (!ordonnanceRepository.existsById(id)) {
            throw new RuntimeException("Ordonnance non trouvée avec ID : " + id);
        }
        ordonnanceRepository.deleteById(id);
    }
}
