package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Livre")
public class Livre extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idLivre;
	@Column
	private String titre;
	@Column
	private Date datePublication;
	@Column
	private int nbDisponibles;
	@Column
	private double prix;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="idAuteur")
	private Auteur auteur;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="idCatalogue")
	private SousCatalogue catalogue;
	
	public Livre() throws RemoteException{}
	
	public Livre(String titre, int nbDisponibles, double prix, Auteur auteur, SousCatalogue catalogue) throws RemoteException {
		this.titre = titre;
		this.nbDisponibles = nbDisponibles;
		this.prix = prix;
		this.auteur = auteur;
		this.catalogue = catalogue;
		this.datePublication = new Date();
	}

	public long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public int getNbDisponibles() {
		return nbDisponibles;
	}

	public void setNbDisponibles(int nbDisponibles) {
		this.nbDisponibles = nbDisponibles;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public SousCatalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(SousCatalogue catalogue) {
		this.catalogue = catalogue;
	}
		
}
