package tp.appliJpa.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//NO @Entity , No @Table here but only in subclasses 
//(Client avec liste de comptes, ClientAvecAdresse)
@MappedSuperclass //NB: @MappedSuperclass is important, abstract may be omitted
public abstract class AbstractClient {
	
	@Id //identifiant (clef primaire / pk)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr qui remonte en mémoire 
	private Long id;
	
	private String prenom;
	private String nom;
	

	public AbstractClient() {
		this(null,null,null);
	}
	

	public AbstractClient(Long id, String prenom, String nom) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
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

	
	
	

}
