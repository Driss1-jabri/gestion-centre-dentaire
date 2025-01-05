package org.example.consultationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.entities.FicheTraitement;
import org.example.consultationservice.services.FicheTraitementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fichetraitement")

public class FicheTraitementController {

    private final FicheTraitementService ficheTraitementService;

    public FicheTraitementController(FicheTraitementService ficheTraitementService) {
        this.ficheTraitementService = ficheTraitementService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<FicheTraitement> createFicheTraitement(@RequestBody FicheTraitement ficheTraitement) {
        return ResponseEntity.ok(ficheTraitementService.createFicheTraitement(ficheTraitement));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<FicheTraitement>> getAllFichesTraitement() {
        return ResponseEntity.ok(ficheTraitementService.getAllFichesTraitement());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheTraitement> getFicheTraitementById(@PathVariable Long id) {
        return ficheTraitementService.getFicheTraitementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FicheTraitement> updateFicheTraitement(@PathVariable Long id, @RequestBody FicheTraitement updatedFicheTraitement) {
        return ResponseEntity.ok(ficheTraitementService.updateFicheTraitement(id, updatedFicheTraitement));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFicheTraitement(@PathVariable Long id) {
        ficheTraitementService.deleteFicheTraitement(id);
        return ResponseEntity.noContent().build();
    }
}
