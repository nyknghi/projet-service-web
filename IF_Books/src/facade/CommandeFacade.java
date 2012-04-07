package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CommandeFacade extends Remote{
	public void calculMontant() throws RemoteException;
	public double getMontant() throws RemoteException;
}
