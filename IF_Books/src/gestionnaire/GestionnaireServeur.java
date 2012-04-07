package gestionnaire;


import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class GestionnaireServeur {
	static IGestionnaire gest;
	
	public GestionnaireServeur(){
		try {
			//Registry r = LocateRegistry.getRegistry();
			
			//if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
						
			gest = new Gestionnaire();
			Naming.rebind("rmi://localhost/GestionnaireServeur", gest);
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
