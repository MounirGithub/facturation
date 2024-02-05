package ekwateur.kata.facturation.service;

import ekwateur.kata.facturation.model.Client;
import ekwateur.kata.facturation.model.ClientPro;
import ekwateur.kata.facturation.model.Energie;
import ekwateur.kata.facturation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturationService {
    private final ClientRepository clientRepository;

    @Autowired
    public FacturationService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public double calculerMontant(String clientId, String energie, double quantite) {
        Client client = clientRepository.findById(clientId).get();
        double prixKwh = (client instanceof ClientPro && ((ClientPro) client).getCA() > 1000000) ?
                (energie.equals("Electricité") ? 0.114 : 0.111) :
                (client instanceof ClientPro && ((ClientPro) client).getCA() < 1000000) ?
                (energie.equals("Electricité") ? 0.118 : 0.113) :
                        (energie.equals("Electricité") ? 0.121 : 0.115);

        return quantite * prixKwh;
    }
}
