package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import facade.LivreFacade;

public class Livre extends UnicastRemoteObject implements LivreFacade{
	private static final long serialVersionUID = 1L;
	private long idLivre;
	private String titre;
	private Date datePublication;
	private int nbDisponibles;
	private double prix;
	private Auteur auteur;
	private SousCatalogue catalogue;
	
	public Livre() throws RemoteException{}
	
	public Livre(long id, String titre, int nbDisponibles, double prix, Auteur auteur, SousCatalogue catalogue) throws RemoteException {
		this.idLivre = id;
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

	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", titre=" + titre
				+ ", datePublication=" + datePublication + ", nbDisponibles="
				+ nbDisponibles + ", prix=" + prix + ", auteur=" + auteur
				+ ", catalogue=" + catalogue + "]";
	}
}
