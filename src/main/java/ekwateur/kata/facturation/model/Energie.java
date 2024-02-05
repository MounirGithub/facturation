package ekwateur.kata.facturation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Energie {
    private String type;
    private double prixKwh;

    public Energie(String type, double prixKwh) {
        this.type = type;
        this.prixKwh = prixKwh;
    }
}