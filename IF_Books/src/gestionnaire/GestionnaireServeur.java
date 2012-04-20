package gestionnaire;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GestionnaireServeur {
	static IGestionnaire gest;
	
	public GestionnaireServeur(){
		Util.execPath();
		try {
			Util.PATH_USER_DIR=System.getProperty("user.dir");
			System.setProperty("java.security.policy", Util.PATH_POLICY);
			System.setProperty("java.rmi.server.codebase", Util.PATH_CODEBASE);
			Registry r = LocateRegistry.getRegistry();		
			
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
						
			gest = new Gestionnaire();
			gest.ajouterSousCatalogue(1, "Gestion");
			gest.ajouterAuteur(1, "AAA");
			
			gest.ajouterLivre(1, "Finance", 3, 25.0, 1, 1);
			gest.ajouterClient(2,"tata","toto", "toto", "AUTEUR");
			gest.ajouterAuteur(2, "tata");
			r.rebind("rmi://localhost/GestionnaireServeur", gest);
			System.out.println("Server started !");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new GestionnaireServeur();		
	}
}
