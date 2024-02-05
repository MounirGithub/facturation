package ekwateur.kata.facturation.service;

import ekwateur.kata.facturation.exception.ClientNotFoundException;
import ekwateur.kata.facturation.model.Client;
import ekwateur.kata.facturation.model.ClientPro;
import ekwateur.kata.facturation.model.Energie;
import ekwateur.kata.facturation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturationService {
    private final ClientRepository clientRepository;

    @Autowired
    public FacturationService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client recupererClient(String clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + clientId));
        return client;
    }

    public List<Client> recupererClient() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public double calculerMontant(String clientId, String energie, double quantite) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + clientId));

            double prixKwh = (client instanceof ClientPro && ((ClientPro) client).getCA() > 1000000) ?
                    (energie.equals("Electricité") ? 0.114 : 0.111) :
                    (client instanceof ClientPro && ((ClientPro) client).getCA() < 1000000) ?
                            (energie.equals("Electricité") ? 0.118 : 0.113) :
                            (energie.equals("Electricité") ? 0.121 : 0.115);

            return quantite * prixKwh;
    }

}
