package gestionnaire;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import pojo.Livre;
import pojo.SousCatalogue;

/* Observer */
public class Ordinateur extends UnicastRemoteObject implements IOrdinateur{
	private static final long serialVersionUID = 1L;

	private SousCatalogue sousCatalogue;
	
	public Ordinateur() throws RemoteException{
		super();
	}
	
	public void subscribeToObservee() {
		try {
			Util.execPath();
			Util.PATH_USER_DIR=System.getProperty("user.dir");
			System.setProperty("java.security.policy", Util.PATH_POLICY);
			System.setProperty("java.rmi.server.codebase", Util.PATH_CODEBASE);
			
			Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			gest.subscribe(this);
			
			//gest.find();
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}

	public SousCatalogue getSousCatalogue() {
		return sousCatalogue;
	}

	public void setSousCatalogue(SousCatalogue sousCatalogue) {
		this.sousCatalogue = sousCatalogue;
	}

	@Override
	public void ajouterLivre(Livre livre) throws RemoteException {
		if (livre.getCatalogue().getIdCatalogue() == this.sousCatalogue.getIdCatalogue()){
			System.out.println("Nouveau livre ajoute !");
			this.sousCatalogue.ajouterLivre(livre);
		}
		
	}

	@Override
	public void supprimerLivre(Livre livre) throws RemoteException {
		if (livre.getCatalogue().getIdCatalogue() == this.sousCatalogue.getIdCatalogue()){
			System.out.println("Nouveau livre ajoute !");
			this.sousCatalogue.removeLivre(livre.getIdLivre());
		}		
	}
}

