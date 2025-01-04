package org.example.facturationservice.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.entities.Paiement;
import org.example.facturationservice.repositories.FactureRepository;
import org.example.facturationservice.repositories.PaiementRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactureService {
    private final FactureRepository factureRepository;
    private final PaiementRepository paiementRepository;

    // Get all factures
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    // Get facture by ID
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture not found"));
    }

    // Add a new facture
    public Facture addFacture(Facture facture) {
        if (facture.getListPaiement() != null) {
            for (Paiement paiement : facture.getListPaiement()) {
                paiement.setFacture(facture);
            }
        }
        return factureRepository.save(facture);
    }

    // Update an existing facture
    public Facture updateFacture(Long id, Facture updatedFacture) {
        Facture existingFacture = getFactureById(id);
        existingFacture.setMontantTotal(updatedFacture.getMontantTotal());
        existingFacture.setMontantPaye(updatedFacture.getMontantPaye());
        return factureRepository.save(existingFacture);
    }

    // Delete a facture by ID
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }
}
