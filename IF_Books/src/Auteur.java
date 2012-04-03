

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class Auteur extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	private long idAuteur;
	private String nom;
	private Set<Livre> livres = new HashSet<Livre>();
	
	public Auteur() throws RemoteException{}
	
	public Auteur(long idAuteur, String nom) throws RemoteException{
		this.idAuteur = idAuteur;
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
	
	public void removeLivre(long idLivre){
		this.livres.remove(idLivre);
	}
}
