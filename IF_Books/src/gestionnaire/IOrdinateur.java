package gestionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;

import facade.LivreFacade;
import facade.SousCatalogueFacade;

public interface IOrdinateur extends Remote{
	public void ajouterLivre(LivreFacade livre) throws RemoteException;
	public void supprimerLivre(LivreFacade livre) throws RemoteException;
	public SousCatalogueFacade getSousCatalogue() throws RemoteException;
	public void setSousCatalogue(SousCatalogueFacade sousCatalogue) throws RemoteException;
	public long getIdOrdinateur() throws RemoteException;
	public void setIdOrdinateur(long idOrdinateur) throws RemoteException;
}
