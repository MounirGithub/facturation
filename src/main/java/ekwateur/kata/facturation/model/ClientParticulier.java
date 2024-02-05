package ekwateur.kata.facturation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class ClientParticulier extends Client {
    private String civilite;
    private String nom;
    private String prenom;

    public ClientParticulier(String referenceClient, String civilite, String nom, String prenom) {
        super(referenceClient);
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }
}