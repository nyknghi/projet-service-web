package facade;

import java.rmi.RemoteException;
import java.util.Set;

public interface AuteurFacade extends ClientFacade{
	public long getIdAuteur() throws RemoteException;
	public void setIdAuteur(long idAuteur) throws RemoteException;
	public String getNom() throws RemoteException;
	public void setNom(String nom) throws RemoteException;
	public Set<LivreFacade> getLivreFacade() throws RemoteException;
}
