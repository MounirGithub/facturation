package ekwateur.kata.facturation.repository;

import ekwateur.kata.facturation.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testFindByReferenceClient() {
        Client client = new Client("EKW12345678");
        clientRepository.save(client);

        Client foundClient = clientRepository.findById("EKW12345678").orElse(null);
        assertThat(foundClient).isNotNull();
        assertThat(foundClient.getReferenceClient()).isEqualTo(client.getReferenceClient());
    }
}
