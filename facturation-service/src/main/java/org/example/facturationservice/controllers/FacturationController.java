package org.example.facturationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.services.FacturationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/facturation")
@RestController
public class FacturationController {
    private final FacturationService facturationService;

    // Get all factures
    @GetMapping
    public List<Facture> getAllFactures() {
        return facturationService.getAllFactures();
    }

    // Get facture by ID
    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return facturationService.getFactureById(id);
    }

    // Add a new facture
    @PostMapping
    public Facture addFacture(@RequestBody Facture facture) {
        return facturationService.addFacture(facture);
    }

    // Update an existing facture
    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture updatedFacture) {
        return facturationService.updateFacture(id, updatedFacture);
    }

    // Delete a facture by ID
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id) {
        facturationService.deleteFacture(id);
    }
}
