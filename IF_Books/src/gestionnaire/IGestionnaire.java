package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import facade.ClientFacade;
import facade.LivreFacade;

public interface IGestionnaire extends Remote{
	public void ajouterAuteur(long id, String nom) throws RemoteException;
	public void ajouterSousCatalogue(long idCat, String intitule) throws RemoteException;
	
	public void ajouterLivre (long id, String titre, int nbDisponibles, double prix, long idAuteur, long idCatalogue) throws RemoteException;
	public void supprimerLivre (long idLivre) throws RemoteException;
	public LivreFacade rechercherParId(long idLivre) throws RemoteException;
	public Map<Long,LivreFacade> rechercherParTitre (String titre) throws RemoteException;
	public Map<Long,LivreFacade> rechercherParAuteur (long idAuteur) throws RemoteException;
	public boolean estDisponible(long idLivre) throws RemoteException; 
	
	public void ajouterCommande(long id, ClientFacade client, Map<Integer, LivreFacade> livres) throws RemoteException;
	
	public ClientFacade rechercherClientParId(long idClient) throws RemoteException;
	public boolean verifierFonds(long idClient, double montantAchat) throws RemoteException;
	
}
