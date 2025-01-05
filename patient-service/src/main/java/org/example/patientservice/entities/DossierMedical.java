package org.example.patientservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class DossierMedical {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String medicalHistory;
  private String currentMedications;

  @OneToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}