package ekwateur.kata.facturation.controller;

import ekwateur.kata.facturation.model.Client;
import ekwateur.kata.facturation.service.FacturationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturationController {

    private final FacturationService facturationService;

    @Autowired
    public FacturationController(FacturationService facturationService) {
        this.facturationService = facturationService;
    }

    @PostMapping("/facturer")
    public ResponseEntity<FacturationResponse> facturerClient(
            @RequestParam String clientId,
            @RequestParam String energyType,
            @RequestParam double quantity) {
        double montant = facturationService.calculerMontant(clientId, energyType, quantity);

        FacturationResponse response = new FacturationResponse(montant);
        return ResponseEntity.ok(response);
    }
}
