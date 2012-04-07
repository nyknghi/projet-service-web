package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class BookStore extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;

	private Set<Auteur> auteurs;
	private Set<Commande> commandes;
	private Catalogue catalogue;
	
	private static BookStore instance; 
	
	public BookStore() throws RemoteException{
		auteurs = new HashSet<Auteur>();
		commandes = new HashSet<Commande>();
		catalogue = Catalogue.getInstance();
	}

	public static BookStore getInstance() throws RemoteException{
		if (instance==null)
			instance = new BookStore();
		return instance;	
	}
	
	public Auteur findAuteur(long idAuteur){
		for (Auteur a : auteurs){
			if (a.getIdAuteur() == idAuteur)
				return a;
		}
		return null;
	}
	
	public Set<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Set<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	
}
