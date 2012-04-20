package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SousCatalogueFacade extends Remote{
	public long getIdCatalogue() throws RemoteException;
	public void setIdCatalogue(long idCatalogue) throws RemoteException;
	public void ajouterLivre(LivreFacade livre) throws RemoteException;
	public void removeLivre(long idLivre) throws RemoteException;
}
