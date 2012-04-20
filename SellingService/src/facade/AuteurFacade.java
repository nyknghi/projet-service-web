package facade;

import java.rmi.RemoteException;

public interface AuteurFacade extends ClientFacade{
	public long getIdAuteur() throws RemoteException;
	public void setIdAuteur(long idAuteur) throws RemoteException;
	public String getNom() throws RemoteException;
	public void setNom(String nom) throws RemoteException;
}
