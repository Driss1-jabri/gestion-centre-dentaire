package org.example.consultationservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordonnances")
@Data
@Builder

public class Ordonnance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToOne(mappedBy = "ordonnance", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Consultation consultation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public Ordonnance() {
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Ordonnance(Long id, String description, Consultation consultation) {
        this.id = id;
        this.description = description;
        this.consultation = consultation;
    }
}
