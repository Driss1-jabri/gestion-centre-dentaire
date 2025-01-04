package org.example.consultationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "consultations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    private Long id;
    private String motif; // Correction du nom
    @OneToOne
    @JoinColumn(name = "ordonnance_id", referencedColumnName = "id")
    private Ordonnance ordonnance;
    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    private RendezVous rendezVous;
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FicheTraitement> fichesDeTraitement; // Correction du nom
}
