package org.example.consultationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.entities.RendezVous;
import org.example.consultationservice.services.RendezvousService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rendezvous")

public class RendezvousController {

    private final RendezvousService rendezVousService;

    public RendezvousController(RendezvousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<RendezVous> createRendezVous(@RequestBody RendezVous rendezVous) {
        return ResponseEntity.ok(rendezVousService.createRendezVous(rendezVous));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<RendezVous>> getAllRendezVous() {
        return ResponseEntity.ok(rendezVousService.getAllRendezVous());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable Long id, @RequestBody RendezVous updatedRendezVous) {
        return ResponseEntity.ok(rendezVousService.updateRendezVous(id, updatedRendezVous));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
        return ResponseEntity.noContent().build();
    }
}
