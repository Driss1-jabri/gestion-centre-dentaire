package org.example.patientservice.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.patientservice.entities.DossierMedical;
import org.example.patientservice.entities.Patient;
import org.example.patientservice.repositories.DossierMedicalRepository;
import org.example.patientservice.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service

public class PatientService {
  private final PatientRepository patientRepository;
  private final DossierMedicalRepository dossierMedicalRepository;
  public PatientService(PatientRepository patientRepository, DossierMedicalRepository dossierMedicalRepository) {
    this.patientRepository = patientRepository;
    this.dossierMedicalRepository = dossierMedicalRepository;
  }

  public List<Patient> getAllPatients() {

    return patientRepository.findAll();
  }

  public Patient getPatientById(Long id) {
    return patientRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Patient not found"));
  }

  public Patient addPatient(Patient patient) {
    if (patient.getDossierMedical() != null) {
      DossierMedical dossier = patient.getDossierMedical();
      dossier.setPatient(patient);
    }
    return patientRepository.save(patient);
  }

  public Patient updatePatient(Long id, Patient updatedPatient) {
    Patient existingPatient = getPatientById(id);
    existingPatient.setFirstName(updatedPatient.getFirstName());
    existingPatient.setLastName(updatedPatient.getLastName());
    existingPatient.setAge(updatedPatient.getAge());
    existingPatient.setGender(updatedPatient.getGender());
    existingPatient.setPhone(updatedPatient.getPhone());
    existingPatient.setEmail(updatedPatient.getEmail());
    return patientRepository.save(existingPatient);
  }

  public void deletePatient(Long id) {
    patientRepository.deleteById(id);
  }
}