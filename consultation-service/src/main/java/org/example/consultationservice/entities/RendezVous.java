package org.example.consultationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "rendezvous")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {
    @Id
    private Long id;
    private LocalDate date;
    private byte heure; // Peut être remplacé par LocalTime si nécessaire
    private String status;
    private Long idPatient;
    @OneToOne
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public byte getHeure() {
        return heure;
    }

    public void setHeure(byte heure) {
        this.heure = heure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public RendezVous() {
    }

    public RendezVous(Long id, LocalDate date, byte heure, String status, Long idPatient, Consultation consultation) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.status = status;
        this.idPatient = idPatient;
        this.consultation = consultation;
    }
}
