package tp.appliSpring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  numero;
	
	private String label;
	
	private Double solde;
	
	//NB: mappedBy="nom_java_relation_inverse"
	//du coté secondaire d'une relation bidirectionnelle
	@OneToMany(mappedBy="compte" , fetch = FetchType.EAGER)
	private List<Operation> operations ;  //+get/set



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



}
