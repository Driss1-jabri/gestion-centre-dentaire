package org.example.patientservice.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.patientservice.entities.Patient;
import org.example.patientservice.services.PatientService;
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
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;

  @GetMapping
  public List<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  @GetMapping("/{id}")
  public Patient getPatientById(@PathVariable Long id) {
    return patientService.getPatientById(id);
  }

  @PostMapping
  public Patient addPatient(@RequestBody Patient patient) {
    return patientService.addPatient(patient);
  }

  @PutMapping("/{id}")
  public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
    return patientService.updatePatient(id, patient);
  }

  @DeleteMapping("/{id}")
  public void deletePatient(@PathVariable Long id) {
    patientService.deletePatient(id);
  }
}
