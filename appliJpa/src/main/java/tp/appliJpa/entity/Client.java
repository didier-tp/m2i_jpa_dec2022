package tp.appliJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
//@Table(name="client")
public class Client {
	
	@Id //identifiant (clef primaire / pk)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr qui remonte en mémoire 
	private Long id;
	
	private String prenom;
	private String nom;
	
	@ManyToMany( fetch = FetchType.LAZY)
	 @JoinTable(name = "client_compte",
	 joinColumns = {@JoinColumn(name = "id_client")},
	 inverseJoinColumns = {@JoinColumn(name = "num_compte")})
	private List<Compte> comptes ;
	
	@OneToOne(optional=true,
			  mappedBy="client",
			  cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private AdresseClient adresse;//may be null if not known or not specified or not attached
	
	
	public Client() {
		this(null,null,null,new ArrayList<>());
	}
	
	public Client(Long id, String prenom, String nom) {
		this(id,prenom,nom,new ArrayList<>());
	}
	

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	public Client(Long id, String prenom, String nom, List<Compte> comptes) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.comptes = comptes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public AdresseClient getAdresse() {
		return adresse;
	}

	public void setAdresse(AdresseClient adresse) {
		this.adresse = adresse;
		if(adresse!=null)
		    this.adresse.setClient(this);
	}

	

}
