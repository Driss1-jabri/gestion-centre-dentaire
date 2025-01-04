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
}
