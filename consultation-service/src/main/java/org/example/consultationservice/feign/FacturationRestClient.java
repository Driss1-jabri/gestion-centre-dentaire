package org.example.consultationservice.feign;

import org.example.consultationservice.entities.ConsultationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "facturation-service")
public interface FacturationRestClient {
    @GetMapping
    public String getDac();
    @PostMapping("/api/factures")
    public ResponseEntity<?> createFacture(@RequestBody ConsultationRequest consultationRequest);
}
