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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "dtype")
public class Client {
    @Id
    @Column(name = "reference_client")
    private String referenceClient;

    public Client(String referenceClient) {
        this.referenceClient = referenceClient;
    }

}