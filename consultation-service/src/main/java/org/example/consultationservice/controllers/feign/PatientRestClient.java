package org.example.consultationservice.controllers.feign;

import org.example.consultationservice.entities.PatientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientRestClient {
    @GetMapping("/api/patients")
    public ResponseEntity< List<PatientRequest>> getAllPatients();
    @GetMapping("/api/patients/{id}")
     public ResponseEntity<PatientRequest> getPatientById(@PathVariable Long id);
}
