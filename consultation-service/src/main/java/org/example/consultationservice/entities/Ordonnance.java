package org.example.consultationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordonnances")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ordonnance {
    @Id
    private Long id;
    private String description;
    @OneToOne(mappedBy = "ordonnance", cascade = CascadeType.ALL, orphanRemoval = true)
    private Consultation consultation;
}
