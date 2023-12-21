package tp.appJpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Employe.findByFirstname" , query = "SELECT e FROM Employe e WHERE e.firstname = ?1")
@Getter @Setter @NoArgsConstructor @ToString
public class Employe {

    @Column(name="emp_id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String firstname;

    private String lastname;

    public Employe(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
