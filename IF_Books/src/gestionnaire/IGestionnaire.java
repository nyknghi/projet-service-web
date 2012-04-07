package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Set;

import pojo.Client;
import pojo.Livre;

public interface IGestionnaire extends Remote{
	public void ajouterAuteur(long id, String nom) throws RemoteException;
	public void ajouterSousCatalogue(long idCat, String intitule) throws RemoteException;
	
	public void ajouterLivre (long id, String titre, int nbDisponibles, double prix, long idAuteur, long idCatalogue) throws RemoteException;
	public void supprimerLivre (Livre livre) throws RemoteException;
	public Map<Long,Livre> rechercherParTitre (String titre) throws RemoteException;
	public Map<Long,Livre> rechercherParAuteur (long idAuteur) throws RemoteException;
	public boolean estDisponible(long idLivre) throws RemoteException; 
	
	public void ajouterCommande(long id, Client client, Set<Livre> livres) throws RemoteException;
	
	
}
