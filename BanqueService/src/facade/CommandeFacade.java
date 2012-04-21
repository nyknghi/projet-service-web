package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface CommandeFacade extends Remote{
	public void calculMontant() throws RemoteException;
	public double getMontant() throws RemoteException;
	public Map<Integer, LivreFacade> getLivres() throws RemoteException;
}
