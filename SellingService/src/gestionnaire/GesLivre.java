package gestionnaire;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

import facade.LivreFacade;

public class GesLivre {

	public GesLivre() {	}
	static  IGestionnaire gest;
	Map <Integer,Long> panier = new HashMap<Integer,Long>();

	public static void connecter(){

		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			Registry r = LocateRegistry.getRegistry();
			gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public double prixDuLivre(long idLivre) throws RemoteException{
		LivreFacade livre = gest.rechercherParId(idLivre);
		if(livre != null)
			return livre.getPrix();
		else
			return 0;
	}

	public boolean estDisponible(long idLivre) throws RemoteException{
		return gest.estDisponible(idLivre);
	}

	public void ajouterLivrePanier(){

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
