package org.example.facturationservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Facture")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String montantTotal;
    private String montantPaye;
    private Long consultationId ;
    @OneToMany(mappedBy = "facture")
    private List<Paiement> listPaiement = new ArrayList<>();;
}
