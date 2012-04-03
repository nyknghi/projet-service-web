

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Gestionnaire extends UnicastRemoteObject implements IGestionnaire{

	public Gestionnaire() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void ajouterLivre(long id, String titre, int nbDisponibles, double prix,
			Auteur auteur, SousCatalogue catalogue) throws RemoteException {
		Livre livre = new Livre(id, titre, nbDisponibles, prix, auteur, catalogue);
		auteur.ajouterLivre(livre);
		catalogue.ajouterLivre(livre);
	}

	@Override
	public void supprimerLivre(Livre livre) throws RemoteException {
		livre.getCatalogue().removeLivre(livre.getIdLivre());
		livre.getAuteur().removeLivre(livre.getIdLivre());
	}

	@Override
	public Map<Long, Livre> rechercherParTitre(String titre) throws RemoteException {
		Map<Long, Livre> res = new HashMap<Long, Livre>();
		Catalogue catalogue = Catalogue.getInstance();
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

}
