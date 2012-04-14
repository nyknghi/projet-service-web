package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import facade.ClientFacade;

public class Client extends UnicastRemoteObject implements ClientFacade{
	private static final long serialVersionUID = 1L;
	
	private long idClient;
	private String nom;
	private String login;
	private String mdp;
	private String type;
	private double fonds;
	private Map<Long, Commande> commandes = new HashMap<Long, Commande>();
	
	public Client() throws RemoteException{}

	public Client(long idClient, String nom, String login, String mdp) throws RemoteException {
		this.idClient = idClient;
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
		this.fonds = 5.0;
	}

	public void ajouterFonds(double montant){
		fonds += montant;
	}
	
	public void payer(double montant){
		fonds -= montant;
	}
	
	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public double getFonds() {
		return fonds;
	}

	public void setFonds(double fonds) {
		this.fonds = fonds;
	}

	public Map<Long, Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Map<Long, Commande> commandes) {
		this.commandes = commandes;
	}
	
	public void ajouterCommande(Commande commande){
		this.commandes.put(commande.getIdCommande(), commande);
	}

	public String getType() throws RemoteException {
		return this.type;
	}

	public void setType(String type) throws RemoteException {
		this.type = type;
	}
}
