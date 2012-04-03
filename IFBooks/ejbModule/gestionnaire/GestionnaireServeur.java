package gestionnaire;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GestionnaireServeur {
	static IGestionnaire gest;
	
	public GestionnaireServeur(){
		try {
			Registry r = LocateRegistry.getRegistry();
			
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
						
			gest = new Gestionnaire();
			r.bind("rmi://localhost/GestionnaireServeur", gest);
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
