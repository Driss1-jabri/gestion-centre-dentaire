package org.example.consultationservice.repository;

import org.example.consultationservice.entities.FicheTraitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheTraitementRepository extends JpaRepository<FicheTraitement,Long> {
}
