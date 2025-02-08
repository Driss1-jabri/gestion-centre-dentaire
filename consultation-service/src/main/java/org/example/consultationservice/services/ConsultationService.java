package org.example.consultationservice.services;

import org.example.consultationservice.feign.FacturationRestClient;
import org.example.consultationservice.feign.PatientRestClient;
import org.example.consultationservice.entities.Consultation;
import org.example.consultationservice.entities.RendezVous;
import org.example.consultationservice.mappers.ConsultationMapper;
import org.example.consultationservice.mappers.ConsultationMapperImpt;
import org.example.consultationservice.repository.ConsultationRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final RendezvousService rdService;
    private final PatientRestClient patientRestClient;
    private final FacturationRestClient facturationRestClient;
    private final  ConsultationMapperImpt consMapper;
    public ConsultationService(
            ConsultationRepository consultationRepository,
            RendezvousService rdService,
            PatientRestClient patientRestClient,
            FacturationRestClient facturationRestClient,
            ConsultationMapperImpt consMapper
                               ) {
        this.consultationRepository = consultationRepository;
        this.rdService=rdService;
        this.patientRestClient=patientRestClient;
        this.facturationRestClient=facturationRestClient;
        this.consMapper=consMapper;
    }
    // CREATE
    public Consultation createConsultation(Consultation consultation) {
        Consultation consultationDB=consultationRepository.save(consultation);
        facturationRestClient.createFacture(consMapper.toDto(consultationDB));
        return consultationDB;
    }

    // READ
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Long id) {

        return consultationRepository.findById(id);

    }

    // UPDATE
    public Consultation updateConsultation(Long id, Consultation updatedConsultation ) {
        RendezVous rd= rdService.getRendezVousById(updatedConsultation.getRendezVous().getId()).orElseThrow(
                ()-> new RuntimeException("vous n'etes pas en rendez vous")
        );
        return consultationRepository.findById(id)
                .map(existingConsultation -> {
                    existingConsultation.setMotif(updatedConsultation.getMotif());
                    existingConsultation.setOrdonnance(updatedConsultation.getOrdonnance());
                    existingConsultation.setRendezVous(rd);
                    existingConsultation.setFichesDeTraitement(updatedConsultation.getFichesDeTraitement());
                    return consultationRepository.save(existingConsultation);
                })
                .orElseThrow(() -> new RuntimeException("Consultation non trouvée avec ID : " + id));
    }

    // DELETE
    public void deleteConsultation(Long id) {
        if (!consultationRepository.existsById(id)) {
            throw new RuntimeException("Consultation non trouvée avec ID : " + id);
        }
        consultationRepository.deleteById(id);
    }


}
