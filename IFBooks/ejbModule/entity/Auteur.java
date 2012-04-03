package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Auteur")
public class Auteur extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAuteur;
	@Column
	private String nom;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auteur")
	private Set<Livre> livres = new HashSet<Livre>();
	
	public Auteur() throws RemoteException{}
	
	public Auteur(String nom) throws RemoteException{
		this.nom = nom;
	}

	public long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(long idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
