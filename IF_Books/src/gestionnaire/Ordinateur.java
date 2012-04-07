package gestionnaire;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import facade.LivreFacade;

public class Ordinateur {
	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			
			/*Auteur a = new Auteur(1, "AAA");
			SousCatalogue eco_gest = new SousCatalogue(1, "Eco-Gestion");
			*/
			System.out.println("Client connected !");
			
			gest.ajouterSousCatalogue(1, "Gestion");
			gest.ajouterAuteur(1, "AAA");
			
			gest.ajouterLivre(1, "Finance", 3, 25.0, 1, 1);
			//LivreFacade livre =	(LivreFacade) gest.rechercherParTitre("Finance").get(0);
			
			//gest.rechercherParTitre("Finance");
			LivreFacade livre = (LivreFacade) gest.rechercherParTitre("Finance").get(new Long(1));
			
			System.out.println(livre);
			System.out.println(livre.getClass());
			
			System.out.println("End connection !");
		}	
		catch (RemoteException re) {
			System.out.println("java.rmi.RemoteException" + re);
		}
		catch (NotBoundException nbe){
			System.out.println("java.rmi.NotBoundException" + nbe);
		}
	}
}