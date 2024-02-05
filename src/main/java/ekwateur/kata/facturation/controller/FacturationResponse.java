package ekwateur.kata.facturation.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturationResponse {
    private String clientRef;
    private double montant;

    public FacturationResponse(String cRef, double montant) {
        this.clientRef = cRef;
        this.montant = montant;
    }
}
