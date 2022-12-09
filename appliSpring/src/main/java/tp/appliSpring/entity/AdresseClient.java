package tp.appliSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="adresse_de_client")
public class AdresseClient {
	
	@Id
	@Column(name="id_client")
	private Long idClient;
	
	private String rue;
	
	@Column(name="code_postal")
	private String codePostal;
	
	private String ville;
	
	@OneToOne(optional=false)
	@PrimaryKeyJoinColumn
	private Client client;
	
	

	public AdresseClient() {
		super();
	}

	public AdresseClient(String rue, String codePostal, String ville, Client client) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.client = client;
		this.idClient = client.getId();
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "AdresseClient [idClient=" + idClient + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + "]";
	}


}
