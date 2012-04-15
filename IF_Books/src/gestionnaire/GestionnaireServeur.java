package gestionnaire;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GestionnaireServeur {
	static IGestionnaire gest;
	static String PATH_POLICY="D:/my documents/M2_IF/Service web/IF_Books/src/sec.policy";
	static String PATH_CODEBASE="file:///my documents/M2_IF/Service web/IF_Books/src/gestionnaire/";
	
	public GestionnaireServeur(){
		try {
			Registry r = LocateRegistry.getRegistry();
			System.setProperty("java.security.policy", GestionnaireServeur.PATH_POLICY);
			System.setProperty("java.rmi.server.codebase", GestionnaireServeur.PATH_CODEBASE);
			
			
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
						
			gest = new Gestionnaire();
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
