package tp.appJpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@NamedQuery(name = "Operation.findByCompteNumero" , query = "SELECT o FROM Operation o WHERE o.compte.numero = ?1")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="num_op")
    private Long numOp;

    private String label;

    private Double montant;

    @Column(name="date_op")
    @Temporal(TemporalType.DATE)
    private Date dateOp;

    @ManyToOne()
    @JoinColumn(name="num_compte")
    private Compte compte;

    public Operation(Long numOp, String label, Double montant) {
        this.numOp = numOp;
        this.label = label;
        this.montant = montant;
        this.dateOp = new Date();
    }


    @Override
    public String toString() {
        return "Operation{" +
                "numOp=" + numOp +
                ", label='" + label + '\'' +
                ", montant=" + montant +
                ", dateOp=" + dateOp +
                '}';
    }

}