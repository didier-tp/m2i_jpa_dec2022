package tp.appliJpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class ClientAvecAdresse extends BasicClient{

	@OneToOne(optional=true,
			  mappedBy="client",
			  cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private AdresseClient adresse;//may be null if not known or not specified or not attached
	
	
	public ClientAvecAdresse() {
		super();
	}


	public ClientAvecAdresse(Long id, String prenom, String nom) {
		super(id, prenom, nom);
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
