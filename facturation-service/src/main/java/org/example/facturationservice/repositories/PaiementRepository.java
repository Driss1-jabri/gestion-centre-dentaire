package org.example.facturationservice.repositories;

import org.example.facturationservice.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}