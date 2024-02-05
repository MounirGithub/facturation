package ekwateur.kata.facturation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "CLIENT")
@NoArgsConstructor

public class Client {
    @Id
    private String referenceClient;

    public Client(String referenceClient) {
        this.referenceClient = referenceClient;
    }

}