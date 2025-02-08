package org.example.consultationservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.entities.PatientRequest;
import org.example.consultationservice.entities.RendezVous;
import org.example.consultationservice.feign.PatientRestClient;
import org.example.consultationservice.services.RendezvousService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
@RequestMapping("api/rendezvous")

public class RendezvousController {

    private final RendezvousService rendezVousService;
    private final PatientRestClient patientRestClient;

    public RendezvousController(
            RendezvousService rendezVousService,
            PatientRestClient patientRestClient
                                ) {
        this.rendezVousService = rendezVousService;
        this.patientRestClient=patientRestClient;
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
    @GetMapping("/test")
    public PatientRequest getpatient(){

        return patientRestClient.getPati().getBody();

    }
}
