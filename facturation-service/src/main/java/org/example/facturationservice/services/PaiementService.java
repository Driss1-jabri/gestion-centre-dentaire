package org.example.facturationservice.services;

import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.entities.MODEPAIEMENT;
import org.example.facturationservice.entities.Paiement;
import org.example.facturationservice.repositories.FactureRepository;
import org.example.facturationservice.repositories.PaiementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PaiementService {
    private final PaiementRepository paiementRepository;
    private final FacturationService facturationService;

    public PaiementService(PaiementRepository paiementRepository , FacturationService facturationService) {
        this.paiementRepository = paiementRepository;
        this.facturationService = facturationService;
    }

    public Paiement savePaiement(Paiement paiement){
        return paiementRepository.save(paiement);
    }

    public Paiement getPaiementById(Long id){
        return paiementRepository.findById(id).orElseThrow(() -> new RuntimeException("Paiement not found"));
    }

    public List<Paiement> getAllPaiement(){
        return paiementRepository.findAll();
    }

    public void deletePaiement(Long id){
        paiementRepository.findById(id);
    }

    public void addPaiementToFacture(Long factureId , BigDecimal montant , MODEPAIEMENT modepaiement)
    {
        Facture facture = facturationService.getFactureById(factureId);

        BigDecimal remainingAmount = facture.getMontantTotal().subtract(facture.getMontantPaye());
        if (montant.compareTo(remainingAmount) > 0) {
            throw new RuntimeException("Payment amount exceeds the remaining amount");
        }

        Paiement paiement = new Paiement();
        paiement.setMontant(montant);
        paiement.setDatePaiement(LocalDateTime.now());
        paiement.setModePaiement(modepaiement);
        paiement.setFacture(facture);

        BigDecimal newMontantPaye = facture.getMontantPaye().add(montant);
        facture.setMontantPaye(newMontantPaye);

        //0 if the two BigDecimal objects are numerically equal.
        if (facture.getMontantTotal().compareTo(facture.getMontantPaye()) == 0) {
            facture.setFinpaiement(true);
        }

        facture.getListPaiement().add(paiement);

        paiementRepository.save(paiement);
        facturationService.saveFacture(facture);
    }
}
