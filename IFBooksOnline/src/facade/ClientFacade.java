package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientFacade extends Remote{
	public void ajouterFonds(double montant) throws RemoteException;
	public void payer(double montant) throws RemoteException;
	public String getLogin() throws RemoteException;
	public void setLogin(String login) throws RemoteException;
	public String getMdp() throws RemoteException;
	public void setMdp(String mdp) throws RemoteException;
	public String getType() throws RemoteException;
	public void setType(String type) throws RemoteException;
	public long getIdClient() throws RemoteException;
	public void setIdClient(long idClient) throws RemoteException;
	public double getFonds() throws RemoteException;
	public void setFonds(double fonds) throws RemoteException;
}
