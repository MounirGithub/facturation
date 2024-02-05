package ekwateur.kata.facturation.controller;

import ekwateur.kata.facturation.exception.ClientNotFoundException;
import ekwateur.kata.facturation.model.Client;
import ekwateur.kata.facturation.model.ClientPro;
import ekwateur.kata.facturation.service.FacturationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class FacturationController {

    private final FacturationService facturationService;

    @Autowired
    public FacturationController(FacturationService facturationService) {
        this.facturationService = facturationService;
    }

    @PostMapping("/facturer")
    public ResponseEntity<?> facturerClient(
            @RequestParam String clientId,
            @RequestParam String energyType,
            @RequestParam double quantity) {
        try {
            double montant = facturationService.calculerMontant(clientId, energyType, quantity);

            FacturationResponse response = new FacturationResponse(clientId, montant);
            return ResponseEntity.ok(response);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/client/{id}")
    public ResponseEntity<?> getClient(
            @PathVariable String id) {
        try {
            return ResponseEntity.ok(facturationService.recupererClient(id));
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClient() {
            return ResponseEntity.ok(facturationService.recupererClient());
    }
}
