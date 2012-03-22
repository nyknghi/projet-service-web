package entity;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="SousCatalogue")
public class SousCatalogue extends Catalogue{
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="catalogue")
	private Set<Livre> livres = new HashSet<Livre>();
	
	public SousCatalogue() throws RemoteException{
		super();
	}
	
	public SousCatalogue(String intitule) throws RemoteException{
		super(intitule);
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	public void ajouterLivre(Livre livre){
		this.livres.add(livre);
	}
}
