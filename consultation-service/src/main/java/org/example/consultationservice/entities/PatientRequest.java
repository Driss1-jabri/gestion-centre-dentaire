package org.example.consultationservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private DossierMedical dossierMedical;

}
