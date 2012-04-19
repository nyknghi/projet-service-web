package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pojo.Livre;

public interface IOrdinateur extends Remote{
	public void ajouterLivre(Livre livre) throws RemoteException;
	public void supprimerLivre(Livre livre) throws RemoteException;
}
