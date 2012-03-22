package entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Auteur")
public class Auteur {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAuteur;
	@Column
	private String nom;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auteur")
	private Set<Livre> livres = new HashSet<Livre>();
	
	public Auteur(){}
	
	public Auteur(String nom) {
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
