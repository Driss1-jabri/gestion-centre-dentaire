package org.example.patientservice.mappers;



import org.example.patientservice.entities.Patient;
import org.example.patientservice.entities.PatientRequest;

public class PatientMapper {

    // Conversion de Patient en PatientRequest
    public static PatientRequest patientToPatientRequest(Patient patient) {
        if (patient == null) {
            return null;
        }
        // Créer un nouvel objet PatientRequest et le remplir avec les données de Patient
        PatientRequest patientRequest = new PatientRequest();
        patientRequest.setId(patient.getId());
        patientRequest.setFirstName(patient.getFirstName());
        patientRequest.setLastName(patient.getLastName());
        patientRequest.setAge(patient.getAge());
        patientRequest.setGender(patient.getGender());
        patientRequest.setPhone(patient.getPhone());
        patientRequest.setEmail(patient.getEmail());
        patientRequest.setDossierMedical(patient.getDossierMedical()); // S'assurer que le mappage de DossierMedical est bien fait

        return patientRequest;
    }

    // Conversion de PatientRequest en Patient
    public static Patient patientRequestToPatient(PatientRequest patientRequest) {
        if (patientRequest == null) {
            return null;
        }
        // Créer un nouvel objet Patient et le remplir avec les données de PatientRequest
        Patient patient = new Patient();
        patient.setId(patientRequest.getId());
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setAge(patientRequest.getAge());
        patient.setGender(patientRequest.getGender());
        patient.setPhone(patientRequest.getPhone());
        patient.setEmail(patientRequest.getEmail());
        patient.setDossierMedical(patientRequest.getDossierMedical()); // S'assurer que le mappage de DossierMedical est bien fait

        return patient;
    }
}
