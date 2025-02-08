package org.example.facturationservice.services;

import org.example.facturationservice.entities.ConsultationRequest;
import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.entities.Paiement;
import org.example.facturationservice.repositories.FactureRepository;
import org.example.facturationservice.repositories.PaiementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FacturationService {
    private final FactureRepository factureRepository;
    private final PaiementRepository paiementRepository;

    public FacturationService(FactureRepository factureRepository, PaiementRepository paiementRepository) {
        this.factureRepository = factureRepository;
        this.paiementRepository = paiementRepository;
    }

    public Facture saveFacture(Facture facture){
        return factureRepository.save(facture);
    }

    // CREATE Facture with patient verification
        public Facture addFacture(ConsultationRequest consultationRequest) {
        Facture facture = new Facture();
        facture.setConsultationRequest(consultationRequest);
        facture.setDate(LocalDate.now());
            facture.setFinpaiement(false);
        facture.setListPaiement(null);
        facture.setMontantPaye(BigDecimal.ZERO);
        facture.setMontantTotal(consultationRequest.getMontantTotal());
        facture.setConsultationId(consultationRequest.getId());
        return factureRepository.save(facture);
    }

    // UPDATE an existing paiement
    public Paiement updatePaiement(Long paiementId, Paiement updatedPaiement) {
        Paiement existingPaiement = paiementRepository.findById(paiementId)
                .orElseThrow(() -> new RuntimeException("Paiement not found"));
        existingPaiement.setMontant(updatedPaiement.getMontant());
        existingPaiement.setDatePaiement(updatedPaiement.getDatePaiement());
        existingPaiement.setModePaiement(updatedPaiement.getModePaiement());
        return paiementRepository.save(existingPaiement);
    }

    public Facture getFactureById(Long id)
    {
        return factureRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
    }

    // DELETE a paiement by ID
    public void deletePaiement(Long paiementId) {
        paiementRepository.deleteById(paiementId);
    }
}
