package ekwateur.kata.facturation.service;

import ekwateur.kata.facturation.model.Client;
import ekwateur.kata.facturation.model.Energie;
import ekwateur.kata.facturation.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class FacturationServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private FacturationService facturationService;

    @Test
    void testCalculerMontant() {
        Client client = new Client("EKW12345678");
        Energie energie = new Energie("Electricité", 0.121);
        double quantity = 100;

        when(clientRepository.findById("EKW12345678")).thenReturn(java.util.Optional.of(client));

        double montant = facturationService.calculerMontant("EKW12345678", "Electricité", quantity);
        assertThat(montant).isEqualTo(12.1);
    }
}
