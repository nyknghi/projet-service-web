package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import entity.Auteur;
import entity.Livre;
import entity.SousCatalogue;

public interface IGestionnaire extends Remote{
	public void ajouterLivre (String titre, int nbDisponibles, double prix, Auteur auteur, SousCatalogue catalogue) throws RemoteException;
	public void supprimerLivre (long idLivre) throws RemoteException;
	public Set<Livre> rechercherParTitre (String titre) throws RemoteException;
	public Set<Livre> rechercherParAuteur (long idAuteur) throws RemoteException;
	public boolean estDisponible(long idLivre) throws RemoteException;
	
	public Auteur rechercherAuteur(long idAuteur) throws RemoteException; 
}
