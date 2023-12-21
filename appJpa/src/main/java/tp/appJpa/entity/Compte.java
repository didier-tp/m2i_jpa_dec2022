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
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private String label;

    private Double solde;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "compte")
    private List<Operation> operations = new ArrayList<>();

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
