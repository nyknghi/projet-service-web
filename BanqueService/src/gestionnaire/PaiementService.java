package gestionnaire;

import facade.ClientFacade;
import facade.CommandeFacade;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PaiementService {
	static IGestionnaire gest;
	
	public PaiementService(){}
	
	public static void connecter(){
		
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			Registry r = LocateRegistry.getRegistry();
			gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isFondsDispo(long idClient, double montant) throws RemoteException{
		PaiementService.connecter();
		return gest.verifierFonds(idClient, montant);
	}
	
	public static boolean checkCommande(long idClient, long idCommande) throws RemoteException{
		PaiementService.connecter();
		CommandeFacade commande = gest.rechercherCommande(idCommande);
		return isFondsDispo(idClient, commande.getMontant());
	}
	
	public static void effectuerPaiement(long idClient, long idCommande) throws RemoteException{
		PaiementService.connecter();
		CommandeFacade commande = gest.rechercherCommande(idCommande);
		ClientFacade client = gest.rechercherClientParId(idClient);
		client.payer(commande.getMontant());
	}
}
