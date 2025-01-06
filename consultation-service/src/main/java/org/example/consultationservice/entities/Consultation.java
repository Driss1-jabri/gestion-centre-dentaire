package org.example.consultationservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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


public class Consultation {
    @Id
    private Long id;
    private String motif; // Correction du nom
    @OneToOne
    @JoinColumn(name = "ordonnance_id", referencedColumnName = "id")
    private Ordonnance ordonnance;
    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    private RendezVous rendezVous;
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<FicheTraitement> fichesDeTraitement;
    // Correction du nom

    public Consultation(Long id, String motif, Ordonnance ordonnance, RendezVous rendezVous, Set<FicheTraitement> fichesDeTraitement) {
        this.id = id;
        this.motif = motif;
        this.ordonnance = ordonnance;
        this.rendezVous = rendezVous;
        this.fichesDeTraitement = fichesDeTraitement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Set<FicheTraitement> getFichesDeTraitement() {
        return fichesDeTraitement;
    }

    public void setFichesDeTraitement(Set<FicheTraitement> fichesDeTraitement) {
        this.fichesDeTraitement = fichesDeTraitement;
    }

    public Consultation() {
    }

    public Long getId() {
        return id;
    }
}
