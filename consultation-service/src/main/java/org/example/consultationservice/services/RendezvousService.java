package org.example.consultationservice.services;

import lombok.RequiredArgsConstructor;
import org.example.consultationservice.controllers.feign.PatientRestClient;
import org.example.consultationservice.entities.PatientRequest;
import org.example.consultationservice.repository.Rendezvousrepository;
import org.example.consultationservice.entities.RendezVous;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class RendezvousService {

    private final Rendezvousrepository rendezVousRepository;
    private final PatientRestClient patientRestClient;


    public RendezvousService(
            PatientRestClient patientRestClient,
            Rendezvousrepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.patientRestClient=patientRestClient;
    }

    // CREATE
    public RendezVous createRendezVous(RendezVous rendezVous) {
        if (rendezVous.getIdPatient() != null) {
            try {
                // Appel Feign pour récupérer les informations du patient
                PatientRequest patientDb = patientRestClient.getPatientById(rendezVous.getIdPatient()).getBody();

                if (patientDb != null) {
                    // Si le patient existe, enregistrer le rendez-vous
                    RendezVous rd=rendezVousRepository.save(rendezVous);
                    rd.setPatientRequest(patientDb);
                    return rd ;
                } else {
                    throw new RuntimeException("Patient non trouvé pour l'ID : " + rendezVous.getIdPatient());
                }
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de l'appel au service Patient : " + e.getMessage(), e);
            }
        }
        return null;
    }
    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> rds = rendezVousRepository.findAll();

        // Boucle pour récupérer et ajouter les informations du patient pour chaque rendez-vous
        for (RendezVous rdv : rds) {
            // Vérification de l'existence du patient via le service PatientRestClient
            PatientRequest patient = verifyPatientExistence(rdv.getIdPatient());

            // Si le patient existe, on l'associe au rendez-vous, sinon on met un message ou un état par défaut
            if (patient != null) {
                rdv.setPatientRequest(patient);
            } else {
                rdv.setPatientRequest(null);  // Ou mettez un état par défaut selon votre logique
            }
        }
        return rds;
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        Optional<RendezVous> rendezVous = rendezVousRepository.findById(id);
        System.out.println(rendezVous.get().getStatus());
        if (rendezVous.isPresent()) {
            // Vérification de l'existence du patient avant de récupérer le rendez-vous
                PatientRequest rq=verifyPatientExistence(rendezVous.get().getIdPatient());
            System.out.println(rq.getId());
                rendezVous.get().setPatientRequest(rq);
        }
        return rendezVous;
    }

    // UPDATE
    public RendezVous updateRendezVous(Long id, RendezVous updatedRendezVous) {
        return rendezVousRepository.findById(id)
                .map(existingRendezVous -> {
                    // Vérification de l'existence du patient avant de mettre à jour le rendez-vous
                    verifyPatientExistence(updatedRendezVous.getIdPatient());

                    existingRendezVous.setDate(updatedRendezVous.getDate());
                    existingRendezVous.setHeure(updatedRendezVous.getHeure());
                    existingRendezVous.setStatus(updatedRendezVous.getStatus());
                    existingRendezVous.setIdPatient(updatedRendezVous.getIdPatient());
                    existingRendezVous.setConsultation(updatedRendezVous.getConsultation());

                    return rendezVousRepository.save(existingRendezVous);
                })
                .orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé avec ID : " + id));
    }

    // DELETE
    public void deleteRendezVous(Long id) {
        if (!rendezVousRepository.existsById(id)) {
            throw new RuntimeException("Rendez-vous non trouvé avec ID : " + id);
        }
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé avec ID : " + id));

        // Vérification de l'existence du patient avant la suppression
        verifyPatientExistence(rendezVous.getIdPatient());

        rendezVousRepository.deleteById(id);
    }

    // Méthode pour vérifier l'existence du patient
    private PatientRequest verifyPatientExistence(Long patientId) {
        try {
            PatientRequest patientDb = patientRestClient.getPatientById(patientId).getBody();
            if (patientDb == null) {
                throw new RuntimeException("Patient non trouvé pour l'ID : " + patientId);
            }
            return patientDb;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'appel au service Patient : " + e.getMessage(), e);
        }

    }
}
