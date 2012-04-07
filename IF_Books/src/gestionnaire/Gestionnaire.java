package gestionnaire;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import pojo.Auteur;
import pojo.BookStore;
import pojo.Catalogue;
import pojo.Client;
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
	public void supprimerLivre(Livre livre) throws RemoteException {
		livre.getCatalogue().removeLivre(livre.getIdLivre());
		livre.getAuteur().removeLivre(livre.getIdLivre());
	}


	@Override
	public Map<Long, Livre> rechercherParTitre(String titre) throws RemoteException {
		Map<Long, Livre> res = new HashMap<Long, Livre>();
		Catalogue catalogue = store.getCatalogue();
		Set<SousCatalogue> sousCat = catalogue.getSous_cat();
		for (SousCatalogue sc : sousCat){
			res.putAll(sc.getLivreByTitre(titre));
		}
		return res;
	}
	
	@Override
	public Map<Long, Livre> rechercherParAuteur(long idAuteur) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estDisponible(long idLivre) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void ajouterCommande(long id, Client client, Set<Livre> livres)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
