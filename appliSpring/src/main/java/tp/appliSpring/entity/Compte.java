package tp.appliSpring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/*
 NB: le mot clef FETCH permet de remonter sur demande les operations reliées au compte
 en un seul gros select (même comportement que EAGER mais sur demande seulement).
 pas besoin de ON operation.num_compte = compte.numero car ces infos
 sont déjà précisées via @Id et @JoinColumn dans les classes JAVA
 et de toute façon requête JPQL exprimée qu'avec des noms java et jamais avec noms de table 
 ou de colonne.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", 
 discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CompteCourant")
@NamedQuery(name="Compte.findWithOperationsById",
            query="SELECT c FROM Compte c LEFT JOIN FETCH c.operations WHERE c.numero = :numCompte")
@NamedQuery(name="Compte.findByClientId",
    query="SELECT cpt FROM Client cli LEFT JOIN  cli.comptes cpt WHERE cli.id = :idClient")
//Dans la requête JPQL ci dessus cpt est un alias pour une instance appartenant
//à la collection cli.comptes
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  numero;
	
	private String label;
	
	private Double solde;
	
	//NB: mappedBy="nom_java_relation_inverse"
	//du coté secondaire d'une relation bidirectionnelle
	@OneToMany(mappedBy="compte" , fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST })
	private List<Operation> operations = new ArrayList<>() ;  //+get/set
	
	public void addOperation(Operation op) {
		this.operations.add(op);
		op.setCompte(this); //met à jour la relation bidirectionnelle dans les 2 sens
		//c'est immédiatement cohérent en mémoire , et le coté principal (pas secondaire) 
		//sera sauvegardé en base
	}
	
	@ManyToMany(mappedBy="comptes" , fetch = FetchType.LAZY)
	private List<Client> clients = new ArrayList<>() ;  //+get/set



@Override
public String toString() {
	return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
}



public Compte() {
	super();
}



public Compte(Long numero, String label, Double solde) {
	super();
	this.numero = numero;
	this.label = label;
	this.solde = solde;
}

public Long getNumero() {
	return numero;
}


public void setNumero(Long numero) {
	this.numero = numero;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public Double getSolde() {
	return solde;
}

public void setSolde(Double solde) {
	this.solde = solde;
}



public List<Operation> getOperations() {
	return operations;
}



public void setOperations(List<Operation> operations) {
	this.operations = operations;
}



public List<Client> getClients() {
	return clients;
}



public void setClients(List<Client> clients) {
	this.clients = clients;
}



}
