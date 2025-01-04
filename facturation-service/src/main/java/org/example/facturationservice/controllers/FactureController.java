package org.example.facturationservice.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.facturationservice.entities.Facture;
import org.example.facturationservice.services.FactureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {
    private final FactureService factureService;

    // Get all factures
    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    // Get facture by ID
    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id);
    }

    // Add a new facture
    @PostMapping
    public Facture addFacture(@RequestBody Facture facture) {
        return factureService.addFacture(facture);
    }

    // Update an existing facture
    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture updatedFacture) {
        return factureService.updateFacture(id, updatedFacture);
    }

    // Delete a facture by ID
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
    }
}
