package org.example.consultationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name="consultations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    private Long id;
    private String Motife;
    private Long redezvousid;
    private Long ordonnanceId;
    private Set<FicheTraitement> fichesdeTraitement;


}
