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
		//Util.execPath();
		System.setProperty("java.security.policy", "C:/Users/Eric/Documents/ProjetWebService/IF_Books/src/sec.policy");
		System.out.println("connected !");
		
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
		return gest.verifierFonds(new Long(idClient), montant);
	}
	
	public static boolean checkCommande(long idClient, long idCommande) throws RemoteException{
		PaiementService.connecter();
		CommandeFacade commande = gest.rechercherCommande(new Long(idCommande));
		boolean res = isFondsDispo(idClient, commande.getMontant());
		System.out.println("check commande ok ? : " + res);
		return res;
	}
	
	public static void effectuerPaiement(long idClient, long idCommande) throws RemoteException{
		PaiementService.connecter();
		CommandeFacade commande = gest.rechercherCommande(new Long(idCommande));
		ClientFacade client = gest.rechercherClientParId(new Long(idClient));
		client.payer(commande.getMontant());
		System.out.println("Compte client : " + client.getFonds());
	}
}
