package org.example.ordonnanceservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ordonnances")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ordonnance {
    @Id
    private Long id;
    private String description;
    private Long idConsultation;

}
