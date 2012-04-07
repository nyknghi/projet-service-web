package gestionnaire;

import facade.ClientFacade;
import facade.CommandeFacade;
import facade.LivreFacade;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

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
		return gest.verifierFonds(idClient, montant);
	}
	
	public static boolean checkCommande(long idClient, long idCommande) throws RemoteException{
		CommandeFacade commande = gest.rechercherCommande(idCommande);
		return isFondsDispo(idClient, commande.getMontant());
	}
	
	public static void effectuerPaiement(long idClient, long idCommande) throws RemoteException{
		CommandeFacade commande = gest.rechercherCommande(idCommande);
		ClientFacade client = gest.rechercherClientParId(idClient);
		client.payer(commande.getMontant());
	}
	
	/*
	 * Jeux de test
	 */
	public static void main(String[] args) throws RemoteException {
		connecter();
		System.out.println("Client connected !");
		
		gest.ajouterSousCatalogue(1, "Gestion");
		gest.ajouterAuteur(1, "AAA");
		
		gest.ajouterLivre(1, "Finance", 3, 25.0, 1, 1);
		gest.ajouterLivre(2, "Economie", 3, 15.5, 1, 1);
		LivreFacade finance = (LivreFacade) gest.rechercherParId(new Long(1));
		LivreFacade eco = (LivreFacade) gest.rechercherParId(new Long(2));
		
		System.out.println(finance.afficher());
		System.out.println(eco.afficher());
		
		/*
		 * Creation d'une commande
		 */
		Map<Integer, Long> listeLivreCommandee = new HashMap<Integer, Long>();
		listeLivreCommandee.put(new Integer(1), new Long(1));
		listeLivreCommandee.put(new Integer(3), new Long(2));
		
		ClientFacade client = gest.ajouterClient(1, "Client 1", "c1", "1234");
		client.ajouterFonds(100);
		
		CommandeFacade commande = gest.ajouterCommande(new Long(1), new Long(1), listeLivreCommandee);
		
		commande.calculMontant();
		double montantAchat = commande.getMontant();
		
		System.out.println("Compte client : " + client.getFonds());
		System.out.println("Montant achat : " + montantAchat);
		System.out.println(checkCommande(new Long(1), new Long(1)));
		
		/*
		 * Regler commande
		 */
		effectuerPaiement(new Long(1), new Long(1));
		System.out.println("Nouveau Compte client : " + client.getFonds());
		
		System.out.println("End connection !");
	}
}
