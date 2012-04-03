package gestionnaire;

import entity.Auteur;
import entity.SousCatalogue;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Ordinateur {
	static Context ctx;
	
	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			
			Auteur a = new Auteur("AAA");
			SousCatalogue eco_gest = new SousCatalogue("Eco-Gestion");
			
			gest.ajouterLivre("Finance", 3, 25.0, a, eco_gest);
		}	
		catch (RemoteException re) {
			System.out.println("java.rmi.RemoteException" + re);
		}
		catch (NotBoundException nbe){
			System.out.println("java.rmi.NotBoundException" + nbe);
		}
	}
	
	public static void createContext(){
		try {
			ctx = new InitialContext();
			ctx.addToEnvironment(InitialContext.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			ctx.addToEnvironment(InitialContext.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");
			ctx.addToEnvironment(InitialContext.PROVIDER_URL,
					"jnp://localhost:1099");
			//gest = (IGestionnaire) ctx.lookup("Gestionnaire/remote");			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
