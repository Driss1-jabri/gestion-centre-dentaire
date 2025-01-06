package org.example.consultationservice.services;

import org.example.consultationservice.entities.FicheTraitement;
import org.example.consultationservice.repository.FicheTraitementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FicheTraitementService {


        private final FicheTraitementRepository ficheTraitementRepository;

        public FicheTraitementService(FicheTraitementRepository ficheTraitementRepository) {
            this.ficheTraitementRepository = ficheTraitementRepository;
        }

        // CREATE
        public FicheTraitement createFicheTraitement(FicheTraitement ficheTraitement) {
            return ficheTraitementRepository.save(ficheTraitement);
        }

        // READ
        public List<FicheTraitement> getAllFichesTraitement() {
            return ficheTraitementRepository.findAll();
        }

        public Optional<FicheTraitement> getFicheTraitementById(Long id) {
            return ficheTraitementRepository.findById(id);
        }

        // UPDATE
        public FicheTraitement updateFicheTraitement(Long id, FicheTraitement updatedFicheTraitement) {
            return ficheTraitementRepository.findById(id)
                    .map(existingFicheTraitement -> {
                        existingFicheTraitement.setNomDent(updatedFicheTraitement.getNomDent());
                        existingFicheTraitement.setMontant(updatedFicheTraitement.getMontant());
                        existingFicheTraitement.setDescription(updatedFicheTraitement.getDescription());
                        return ficheTraitementRepository.save(existingFicheTraitement);
                    })
                    .orElseThrow(() -> new RuntimeException("Fiche de traitement non trouvée avec ID : " + id));
        }

        // DELETE
        public void deleteFicheTraitement(Long id) {
            if (!ficheTraitementRepository.existsById(id)) {
                throw new RuntimeException("Fiche de traitement non trouvée avec ID : " + id);
            }
            ficheTraitementRepository.deleteById(id);
        }

}
