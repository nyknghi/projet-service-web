package pojo;

import gestionnaire.IOrdinateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class BookStore extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;

	private Set<Auteur> auteurs;
	private Set<Client> clients;
	private Set<Commande> commandes;
	private Catalogue catalogue;
	private Set<IOrdinateur> ordinateurs = new HashSet<IOrdinateur>();
	
	private static BookStore instance; 
	
	public BookStore() throws RemoteException{
		auteurs = new HashSet<Auteur>();
		commandes = new HashSet<Commande>();
		clients = new HashSet<Client>();
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

	/*public Set<Client> getAllClient(){
		Set<Client> res = new HashSet<Client>();
		//System.out.println(commandes.size());
		for (Commande c : commandes){
			res.add(c.getClient());
		}
		return res;
	}*/
	
	public Set<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Set<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public void addClient(Client c){
		this.clients.add(c);
	}
	
	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public void addCommande(Commande c){
		this.commandes.add(c);
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

	public Set<IOrdinateur> getOrdinateurs() {
		return ordinateurs;
	}

	public void setOrdinateurs(Set<IOrdinateur> ordinateurs) {
		this.ordinateurs = ordinateurs;
	}
	
	public IOrdinateur rechercherOrdinateur(long idOrd) throws RemoteException {
		for (IOrdinateur ord : ordinateurs){
			if (ord.getIdOrdinateur() == idOrd){
				return ord;
			}
		}
		return null;
	}
}
