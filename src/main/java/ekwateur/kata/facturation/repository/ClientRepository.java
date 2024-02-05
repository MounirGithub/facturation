package ekwateur.kata.facturation.repository;

import ekwateur.kata.facturation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Client save(Client entity);

    Optional<Client> findById(String referenceClient);
}
