

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Ordinateur {
	public static void main(String[] args) {
		try {
			//Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) Naming.lookup("rmi://localhost/GestionnaireServeur");
			
			Auteur a = new Auteur(1, "AAA");
			SousCatalogue eco_gest = new SousCatalogue(1, "Eco-Gestion");
			
			gest.ajouterLivre(1, "Finance", 3, 25.0, a, eco_gest);
		}	
		catch (RemoteException re) {
			System.out.println("java.rmi.RemoteException" + re);
		}
		catch (NotBoundException nbe){
			System.out.println("java.rmi.NotBoundException" + nbe);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
