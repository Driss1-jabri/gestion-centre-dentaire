package org.example.facturationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.facturationservice.entities.ConsultationRequest;
import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.entities.MODEPAIEMENT;
import org.example.facturationservice.entities.Paiement;
import org.example.facturationservice.services.FacturationService;
import org.example.facturationservice.services.PaiementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/api/facturation")
@RestController
@RequiredArgsConstructor
public class FacturationController {
    private final FacturationService facturationService;
    private final PaiementService paiementService;

    // Create a new Facture
    @PostMapping
    public Facture addFacture(@RequestBody ConsultationRequest consultationRequest) {
        return facturationService.addFacture(consultationRequest);
    }

    // Get all Factures
    @GetMapping
    public List<Facture> getAllFactures() {
        return facturationService.getAllFacture();
    }

    // Get a Facture by ID
    @GetMapping("/{factureId}")
    public Facture getFactureById(@PathVariable Long factureId) {
        return facturationService.getFactureById(factureId);
    }

    @PutMapping("/{factureId}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture updatedFacture) {
        return facturationService.updateFacture(id, updatedFacture);
    }

    // Add a payment to a Facture
    @PostMapping("/{factureId}/pay")
    public ResponseEntity<?> addPayment(
            @PathVariable Long factureId,
            @RequestParam BigDecimal amount,
            @RequestParam MODEPAIEMENT paymentMode) {
        paiementService.addPaiementToFacture(factureId, amount, paymentMode);
        return ResponseEntity.ok().build();
    }

    // Get all payments for a Facture
    @GetMapping("/{factureId}/payments")
    public List<Paiement> getPaymentsForFacture(@PathVariable Long factureId) {
        return paiementService.getAllPaiement().stream()
                .filter(p -> p.getFacture().getId().equals(factureId))
                .toList();
    }

    
    // Update a payment
    @PutMapping("/payments/{paiementId}")
    public Paiement updatePayment(
            @PathVariable Long paiementId,
            @RequestBody Paiement updatedPaiement) {
        return facturationService.updatePaiement(paiementId, updatedPaiement);
    }

    // Delete a payment
    @DeleteMapping("/payments/{paiementId}")
    public ResponseEntity<?> deletePayment(@PathVariable Long paiementId) {
        paiementService.deletePaiement(paiementId);
        return ResponseEntity.ok().build();
    }

    // Delete a Facture
    @DeleteMapping("/{factureId}")
    public ResponseEntity<?> deleteFacture(@PathVariable Long factureId) {
        facturationService.deleteFacture(factureId);
        return ResponseEntity.ok().build();
    }
}