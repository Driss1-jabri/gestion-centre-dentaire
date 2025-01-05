package org.example.consultationservice.repository;

import org.example.consultationservice.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rendezvousrepository extends JpaRepository<RendezVous,Long> {
}
