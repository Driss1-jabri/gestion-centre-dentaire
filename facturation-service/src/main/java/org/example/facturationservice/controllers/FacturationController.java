package org.example.facturationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.facturationservice.entities.ConsultationRequest;
import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.entities.MODEPAIEMENT;
import org.example.facturationservice.services.FacturationService;
import org.example.facturationservice.services.PaiementService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/api/facturation")
@RestController
public class FacturationController {
    private final FacturationService facturationService;
    private final PaiementService paiementService;

    public FacturationController(FacturationService facturationService , PaiementService paiementService) {
        this.facturationService = facturationService;
        this.paiementService = paiementService;
    }

    // Get all factures
    @PostMapping
    public Facture addFacture(@RequestBody ConsultationRequest consultationRequest) {
        return facturationService.addFacture(consultationRequest);
    }

    @PostMapping("/{factureId}/pay")
    public ResponseEntity<?> addPayment(
            @PathVariable Long factureId,
            @RequestParam BigDecimal amount,
            @RequestParam MODEPAIEMENT paymentMode) {
        paiementService.addPaiementToFacture(factureId, amount, paymentMode);
        return ResponseEntity.ok().build();
    }
}