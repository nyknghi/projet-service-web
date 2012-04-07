package gestionnaire;

import java.rmi.RemoteException;

import facade.LivreFacade;

public class GesBooks {

	public GesBooks() {	}
	
	public double prixDuLivre(LivreFacade livre) throws RemoteException{
		return livre.getPrix();
	}
	
	public boolean estDisponible(LivreFacade livre) throws RemoteException{
		if(livre.getNbDisponibles() == 0)
			return false;
		else
			return true;
	}
	
	public void effectuerAchat(){
		
	}
}
