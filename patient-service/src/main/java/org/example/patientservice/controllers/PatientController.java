package org.example.patientservice.controllers;

import java.util.List;
import org.example.patientservice.entities.Patient;
import org.example.patientservice.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
  private final PatientService patientService;

  public PatientController(PatientService patientService) {

    this.patientService = patientService;
  }

  @GetMapping
  public ResponseEntity<List<Patient>> getAllPatients() {
    return ResponseEntity.ok( patientService.getAllPatients());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
    try {
      Patient patient = patientService.getPatientById(id);
      return new ResponseEntity<>(patient, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
    Patient createdPatient = patientService.addPatient(patient);
    return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
    try {
      Patient patient = patientService.updatePatient(id, updatedPatient);
      return new ResponseEntity<>(patient, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
    try {
      patientService.deletePatient(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}