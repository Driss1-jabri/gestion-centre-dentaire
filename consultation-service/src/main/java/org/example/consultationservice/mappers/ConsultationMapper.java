package org.example.consultationservice.mappers;


import org.example.consultationservice.entities.*;

import java.util.Set;

public interface ConsultationMapper {
    public Consultation toEntity(ConsultationRequest request,
                                 Ordonnance ordonnance,
                                 RendezVous rendezVous,
                                 Set<FicheTraitement> fichesDeTraitement

                                 );
    public ConsultationRequest toDto(Consultation consultation) ;
}
