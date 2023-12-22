package tp.appJpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@NamedQuery(name = "Compte.findWithOperations", query = "SELECT c FROM Compte c INNER JOIN FETCH c.operations WHERE c.numero = ?1")
@NamedQuery(name = "Compte.findByClientId", query = "SELECT c FROM Compte c INNER JOIN FETCH c.clients cli WHERE cli.id = ?1")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private String label;

    private Double solde;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compte")
    private List<Operation> operations = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "client_compte",
            joinColumns = {@JoinColumn(name = "num_compte")},
            inverseJoinColumns = {@JoinColumn(name = "id_client")})
    private List<Client> clients = new ArrayList<>();

    public Compte(Long numero, String label, Double solde) {
        this.numero = numero;
        this.label = label;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numero=" + numero +
                ", label='" + label + '\'' +
                ", solde=" + solde +
                '}';
    }
}
