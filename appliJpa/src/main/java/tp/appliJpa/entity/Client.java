package tp.appliJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;

@Entity
@NamedEntityGraph(name = "entity-graph-client-comptes",
	attributeNodes = {
		    @NamedAttributeNode(value="comptes")
		  }
	)
@NamedEntityGraph(name = "entity-graph-client-comptes-operations",
	attributeNodes = {
	    @NamedAttributeNode(value="comptes" , subgraph = "compte-subgraph")
	  },
	subgraphs = {
		@NamedSubgraph( name = "compte-subgraph",
			    	      attributeNodes = {
			    	        @NamedAttributeNode("operations")
			    	      }
			    	  )
	}
)
@Table(name="client")
public class Client extends BasicClient{
	
	@ManyToMany( fetch = FetchType.LAZY)
	 @JoinTable(name = "client_compte",
	 joinColumns = {@JoinColumn(name = "id_client")},
	 inverseJoinColumns = {@JoinColumn(name = "num_compte")})
	
	private List<Compte> comptes = new ArrayList<>();
	
	public Client(Long id, String prenom, String nom, List<Compte> comptes) {
		super(id,prenom,nom);
		if(comptes!=null)
		    this.comptes = comptes;
		else
			this.comptes = new ArrayList<>();
	}
	
	public Client(Long id, String prenom, String nom) {
		this(id,prenom,nom,null);
	}
	
	public Client() {
		this(null,null,null,null);
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	
}
