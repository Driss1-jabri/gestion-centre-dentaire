package org.example.consultationservice.mappers;

import org.example.consultationservice.entities.*;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component

public class ConsultationMapperImpt {

    public Consultation toEntity(ConsultationRequest request,
                                 Ordonnance ordonnance,
                                 RendezVous rendezVous,
                                 Set<FicheTraitement> fichesDeTraitement

    ) {
        Consultation consultation = new Consultation();
        consultation.setId(request.id());
        consultation.setMotif(request.motif());
        consultation.setOrdonnance(ordonnance);
        consultation.setRendezVous(rendezVous);
        consultation.setFichesDeTraitement(fichesDeTraitement);
        return consultation;
    }


    public ConsultationRequest toDto(Consultation consultation) {
        return new ConsultationRequest(
                consultation.getId(),
                consultation.getMotif(),
                consultation.getOrdonnance() != null ? consultation.getOrdonnance().getId() : null,
                consultation.getRendezVous() != null ? consultation.getRendezVous().getId() : null
        );
    }
}
