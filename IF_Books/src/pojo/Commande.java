package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import facade.CommandeFacade;
import facade.LivreFacade;

public class Commande extends UnicastRemoteObject implements CommandeFacade{
	private static final long serialVersionUID = 1L;
	private long idCommande;
	private Client client;
	
	// Livre et sa quantite
	private Map<Integer, LivreFacade> livres = new HashMap<Integer, LivreFacade>();
	
	private double montant = 0.0;
	private Date dateCommande;
	public enum Etape {
		CREEE, LIVREE, ANNULEE 
	}
	private Etape etape;
	
	public Commande() throws RemoteException{}

	public Commande(long id, Client client) throws RemoteException {
		this.idCommande = id;
		this.client = client;
		this.dateCommande = new Date();
		this.etape = Etape.CREEE;		
		calculMontant();
	}
	
	public void ajouterLivreCommande(LivreFacade livre, int quantite){
		this.livres.put(quantite, livre);		
	}
	
	public void calculMontant() throws RemoteException{
		double res=0;
		for(Entry <Integer, LivreFacade> entry : this.livres.entrySet()) {
			LivreFacade liv = entry.getValue();
			res += liv.getPrix()*entry.getKey();
		}
		this.montant = res;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Map<Integer, LivreFacade> getLivres() {
		return livres;
	}

	public void setLivres(Map<Integer, LivreFacade> livres) {
		this.livres = livres;
	}	
	
	public void valider(){
		if (etape.equals(Etape.CREEE)){
			etape = Etape.LIVREE;
		} else if (etape.equals(Etape.ANNULEE)){
			System.out.println("Commande annulee !");
		}
	}
	
	public void annuler(){
		etape = Etape.ANNULEE;
	}
}
