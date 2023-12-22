package tp.appJpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter @NoArgsConstructor
@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte{
    private Double taux;

    public CompteEpargne(Long numero, String label, Double solde, Double taux) {
        super(numero, label, solde);
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "taux=" + taux +
                "} heritant de " + super.toString();
    }
}
