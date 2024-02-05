package ekwateur.kata.facturation.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturationResponse {
    private double montant;

    public FacturationResponse(double montant) {
        this.montant = montant;
    }
}
