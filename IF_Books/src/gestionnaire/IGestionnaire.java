package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Set;

import facade.AuteurFacade;
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
	public Map<Long, LivreFacade> rechercherParAuteur (long idAuteur) throws RemoteException;
	public Set<LivreFacade> rechercherParNomAuteur (String nomAuteur) throws RemoteException;
	public boolean estDisponible(long idLivre) throws RemoteException;
	
	public ClientFacade ajouterClient (long idClient, String nom, String login, String mdp, String type) throws RemoteException;
	
	public CommandeFacade ajouterCommande(long id, long idClient, Map<Integer, Long> livres) throws RemoteException;
	public CommandeFacade rechercherCommande(long id) throws RemoteException;
	public CommandeFacade validerCommande(long id) throws RemoteException;
	public CommandeFacade annulerCommande(long id) throws RemoteException;
	
	public ClientFacade rechercherClientParId(long idClient) throws RemoteException;
	public boolean verifierFonds(long idClient, double montantAchat) throws RemoteException;
	public long getLastKeyCommande() throws RemoteException;
	public long getLastKeyClient() throws RemoteException;
	public long getLastKeyAuteur() throws RemoteException;
	public AuteurFacade rechercherAuteurParId(long idAuteur) throws RemoteException;
	
	
	public AuteurFacade rechercherAuteurParLogin(String login, String pwd) throws RemoteException;
	public ClientFacade rechercherClientParLogin(String login, String pwd) throws RemoteException;
	
	public void envoyerManuscrit(long idAuteur, long idLivre, long idSousCatalogue) throws RemoteException;
	public void modifierLivre(long idAuteur, long idLivre) throws RemoteException;
	public void validerManuscrit(long idLivre) throws RemoteException;
	
	// Connexion des ordinateurs
	public void subscribe (IOrdinateur ord) throws RemoteException;
	public void unsubscribe (IOrdinateur ord) throws RemoteException;
	
	public int chercher() throws RemoteException;
	
}
