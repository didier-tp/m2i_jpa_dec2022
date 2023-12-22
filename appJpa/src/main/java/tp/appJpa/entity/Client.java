package tp.appJpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@NamedQuery(name = "Client.findByIdWithComptes", query = "SELECT cli FROM Client cli INNER JOIN FETCH cli.comptes WHERE cli.id = ?1")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @ManyToMany(mappedBy="clients")
    private List<Compte> comptes = new ArrayList<>();

    public Client(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
}
