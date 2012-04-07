package gestionnaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import facade.ClientFacade;
import facade.LivreFacade;

import pojo.Auteur;
import pojo.BookStore;
import pojo.Catalogue;
import pojo.Client;
import pojo.Commande;
import pojo.Livre;
import pojo.SousCatalogue;

public class Gestionnaire extends UnicastRemoteObject implements IGestionnaire{
	BookStore store = BookStore.getInstance();
	
	public Gestionnaire() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	
	@Override
	public void ajouterAuteur(long id, String nom) throws RemoteException {
		store.getAuteurs().add(new Auteur(id, nom));		
	}
	
	@Override
	public void ajouterSousCatalogue(long idCat, String intitule) throws RemoteException {
		store.getCatalogue().addSousCatalogue(new SousCatalogue(idCat, intitule));
	}
	
	@Override
	public void ajouterLivre(long id, String titre, int nbDisponibles, double prix,
			long idAuteur, long idCatalogue) throws RemoteException {		
		Auteur a = store.findAuteur(idAuteur);
		SousCatalogue sc = store.getCatalogue().findSousCatalogue(idCatalogue);
		Livre livre = new Livre(id, titre, nbDisponibles, prix, a, sc);
		
		a.ajouterLivre(livre);
		sc.ajouterLivre(livre);
	}

	@Override
	public void supprimerLivre(long idLivre) throws RemoteException {
		Livre livre = (Livre) rechercherParId(idLivre);
		livre.getCatalogue().removeLivre(livre.getIdLivre());
		livre.getAuteur().removeLivre(livre.getIdLivre());
	}

	@Override
	public LivreFacade rechercherParId(long idLivre) throws RemoteException {
		for (SousCatalogue sc : store.getCatalogue().getSous_cat()){
			Livre livre = sc.getLivreParId(idLivre); 
			if (livre != null){
				return livre;
			}
		}
		return null;
	}
	
	@Override
	public Map<Long, LivreFacade> rechercherParTitre(String titre) throws RemoteException {
		Map<Long, LivreFacade> res = new HashMap<Long, LivreFacade>();
		Catalogue catalogue = store.getCatalogue();
		Set<SousCatalogue> sousCat = catalogue.getSous_cat();
		for (SousCatalogue sc : sousCat){
			res.putAll(sc.getLivreByTitre(titre));
		}
		return res;
	}

	@Override
	public Map<Long, LivreFacade> rechercherParAuteur(long idAuteur) throws RemoteException {
		Set<Auteur> auteurs = store.getAuteurs();
		Map<Long, LivreFacade> res = new HashMap<Long, LivreFacade>();
		for (Auteur a : auteurs){
			if (a.getIdAuteur() == idAuteur){
				for (Livre liv : a.getLivres()){
					res.put(liv.getIdLivre(), liv);
				}
			}
		}
		return res;
	}
	
	@Override
	public boolean estDisponible(long idLivre) throws RemoteException {
		LivreFacade livre = rechercherParId(idLivre);
		return livre.isDisponible();
	}

	@Override
	public void ajouterCommande(long id, ClientFacade client, Map<Integer, LivreFacade> livres) throws RemoteException {
		Commande commande = new Commande(id, (Client)client);
		for(Entry <Integer, LivreFacade> entry : livres.entrySet()) {
			Livre liv = (Livre)entry.getValue();
			commande.ajouterLivreCommande(liv, entry.getKey());
		}
		store.ajouterCommande(commande);
	}

	@Override
	public boolean verifierFonds(long idClient, double montantAchat) throws RemoteException {
		ClientFacade client = rechercherClientParId(idClient);
		return (client.getFonds() >= montantAchat);
	}

	@Override
	public ClientFacade rechercherClientParId(long idClient) throws RemoteException {
		Set<Client> clients = store.getAllClient();
		for (Client c : clients){
			if (c.getIdClient() == idClient){
				return (ClientFacade) c;
			}
		}
		return null;
	}

}
