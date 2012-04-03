

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IGestionnaire extends Remote{
	public void ajouterLivre (long id, String titre, int nbDisponibles, double prix, Auteur auteur, SousCatalogue catalogue) throws RemoteException;
	public void supprimerLivre (Livre livre) throws RemoteException;
	public Map<Long,Livre> rechercherParTitre (String titre) throws RemoteException;
	public Map<Long,Livre> rechercherParAuteur (long idAuteur) throws RemoteException;
	public boolean estDisponible(long idLivre) throws RemoteException; 
}
