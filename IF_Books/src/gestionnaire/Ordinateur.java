package gestionnaire;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import pojo.BookStore;
import facade.LivreFacade;
import facade.SousCatalogueFacade;

/* Observer */
public class Ordinateur extends UnicastRemoteObject implements IOrdinateur{
	private static final long serialVersionUID = 1L;
	private long idOrdinateur;
	private SousCatalogueFacade sousCatalogue;
	
	public Ordinateur(long id) throws RemoteException{
		super();
		this.idOrdinateur = id;
		BookStore.getInstance().getOrdinateurs().add(this);
	}
	
	public void subscribeToObservee() {
		try {
			Util.execPath();
			Util.PATH_USER_DIR=System.getProperty("user.dir");
			System.setProperty("java.security.policy", Util.PATH_POLICY);
			System.setProperty("java.rmi.server.codebase", Util.PATH_CODEBASE);
			System.setProperty("java.rmi.server.hostname", "192.168.1.1");
			Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) r.lookup("rmi://localhost:1099/GestionnaireServeur");
			gest.subscribe(this);
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}

	public SousCatalogueFacade getSousCatalogue() {
		return sousCatalogue;
	}

	public void setSousCatalogue(SousCatalogueFacade sousCatalogue) {
		this.sousCatalogue = sousCatalogue;
	}

	@Override
	public void ajouterLivre(LivreFacade livre) throws RemoteException {
		if (this.sousCatalogue!=null){
			if (livre.getCatalogue().getIdCatalogue() == this.sousCatalogue.getIdCatalogue()){
				System.out.println("Ordinateur " + idOrdinateur + " : Nouveau livre " + livre.getIdLivre() + " ajoute !");
				this.sousCatalogue.ajouterLivre(livre);
			}
		}
	}

	@Override
	public void supprimerLivre(LivreFacade livre) throws RemoteException {
		if (livre.getCatalogue().getIdCatalogue() == this.sousCatalogue.getIdCatalogue()){
			System.out.println("Nouveau livre ajoute !");
			this.sousCatalogue.removeLivre(livre.getIdLivre());
		}		
	}

	public long getIdOrdinateur() {
		return idOrdinateur;
	}

	public void setIdOrdinateur(long idOrdinateur) {
		this.idOrdinateur = idOrdinateur;
	}
}

