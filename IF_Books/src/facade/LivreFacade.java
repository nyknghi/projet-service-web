package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import pojo.Auteur;
import pojo.SousCatalogue;

public interface LivreFacade extends Remote{
	public long getIdLivre() throws RemoteException;
	public void setIdLivre(long idLivre) throws RemoteException;
	public String getTitre() throws RemoteException;
	public void setTitre(String titre) throws RemoteException;
	public Date getDatePublication() throws RemoteException;
	public void setDatePublication(Date datePublication) throws RemoteException;
	public int getNbDisponibles() throws RemoteException;
	public void setNbDisponibles(int nbDisponibles) throws RemoteException;
	public double getPrix() throws RemoteException;
	public void setPrix(double prix) throws RemoteException;
	public Auteur getAuteur() throws RemoteException;
	public void setAuteur(Auteur auteur) throws RemoteException;
	public SousCatalogue getCatalogue() throws RemoteException;
	public void setCatalogue(SousCatalogue catalogue) throws RemoteException;
}
