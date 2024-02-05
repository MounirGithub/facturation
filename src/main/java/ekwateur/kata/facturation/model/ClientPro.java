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
public class ClientPro extends Client {
    private String numeroSiret;
    private String raisonSociale;
    private double CA;

    public ClientPro(String referenceClient, String numeroSiret, String raisonSociale, double CA) {
        super(referenceClient);
        this.numeroSiret = numeroSiret;
        this.raisonSociale = raisonSociale;
        this.CA = CA;
    }
}