package org.example.consultationservice.entities;

public class DossierMedical {
    private Long id;
    private String antecedentsMedicaux;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public DossierMedical(Long id, String antecedentsMedicaux) {
        this.id = id;
        this.antecedentsMedicaux = antecedentsMedicaux;
    }
}
