package org.example.consultationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.entities.Ordonnance;
import org.example.consultationservice.services.OrdonnanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordonnance")

public class OrdonnanceController {
    private final OrdonnanceService ordonnanceService;

    public OrdonnanceController(OrdonnanceService ordonnanceService) {
        this.ordonnanceService = ordonnanceService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Ordonnance> createOrdonnance(@RequestBody Ordonnance ordonnance) {
        return ResponseEntity.ok(ordonnanceService.createOrdonnance(ordonnance));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Ordonnance>> getAllOrdonnances() {
        return ResponseEntity.ok(ordonnanceService.getAllOrdonnances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordonnance> getOrdonnanceById(@PathVariable Long id) {
        return ordonnanceService.getOrdonnanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ordonnance> updateOrdonnance(@PathVariable Long id, @RequestBody Ordonnance updatedOrdonnance) {
        return ResponseEntity.ok(ordonnanceService.updateOrdonnance(id, updatedOrdonnance));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdonnance(@PathVariable Long id) {
        ordonnanceService.deleteOrdonnance(id);
        return ResponseEntity.noContent().build();
    }
}
