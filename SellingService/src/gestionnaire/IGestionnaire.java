package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import facade.ClientFacade;
import facade.CommandeFacade;
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
	
	public ClientFacade ajouterClient (long idClient, String nom, String login, String mdp) throws RemoteException;
	
	public CommandeFacade ajouterCommande(long id, long idClient, Map<Integer, Long> livres) throws RemoteException;
	public CommandeFacade rechercherCommande(long id) throws RemoteException;
	
	public ClientFacade rechercherClientParId(long idClient) throws RemoteException;
	public boolean verifierFonds(long idClient, double montantAchat) throws RemoteException;
	public long getLastKeyCommande() throws RemoteException;
	public long getLastKeyClient() throws RemoteException;
	public long getLastKeyAuteur() throws RemoteException;
	
}
