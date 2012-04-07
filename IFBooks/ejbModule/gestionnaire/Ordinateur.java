package gestionnaire;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.Context;

public class Ordinateur {
	static Context ctx;
	
	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			
			/*Auteur a = new Auteur("AAA");
			SousCatalogue eco_gest = new SousCatalogue("Eco-Gestion");
			
			/gest.ajouterLivre("Finance", 3, 25.0, a, eco_gest);*/
			
			gest.ajouterSousCatalogue("Gestion");
			System.out.println("Client connected !");
		}	
		catch (RemoteException re) {
			System.out.println("java.rmi.RemoteException" + re);
		}
		catch (NotBoundException nbe){
			System.out.println("java.rmi.NotBoundException" + nbe);
		}
	}
}
