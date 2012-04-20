package gestionnaire;

import facade.LivreFacade;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Scenario {
	
	public static void main(String[] args) {
		try {
			Ordinateur ord1 = new Ordinateur();
			Ordinateur ord2 = new Ordinateur();
			Ordinateur ord3 = new Ordinateur();
			
			ord1.subscribeToObservee();
			ord2.subscribeToObservee();
			ord3.subscribeToObservee();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void test() {
		try {
			Registry r = LocateRegistry.getRegistry();
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			
			IGestionnaire gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			
			/*Auteur a = new Auteur(1, "AAA");
			SousCatalogue eco_gest = new SousCatalogue(1, "Eco-Gestion");
			*/
			System.out.println("Client connected !");
			
			gest.ajouterSousCatalogue(1, "Gestion");
			gest.ajouterAuteur(1, "AAA");
			
			gest.ajouterLivre(1, "Finance", 3, 25.0, 1, 1);
			//LivreFacade livre =	(LivreFacade) gest.rechercherParTitre("Finance").get(0);
			
			//gest.rechercherParTitre("Finance");
			LivreFacade livre = (LivreFacade) gest.rechercherParTitre("Finance").get(new Long(1));
			
			System.out.println(livre);
			System.out.println(livre.getClass());
			
			System.out.println("End connection !");
		}	
		catch (RemoteException re) {
			System.out.println("java.rmi.RemoteException" + re);
		}
		catch (NotBoundException nbe){
			System.out.println("java.rmi.NotBoundException" + nbe);
		}
	}
	
	/*
	 * Jeux de test
	 */
	/*public static void main(String[] args) throws RemoteException {
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
		 
		Map<Integer, Long> listeLivreCommandee = new HashMap<Integer, Long>();
		listeLivreCommandee.put(new Integer(1), new Long(1));
		listeLivreCommandee.put(new Integer(3), new Long(2));
		
		ClientFacade client = gest.ajouterClient(1, "Client 1", "c1", "1234","CLIENT");
		client.ajouterFonds(100);
		
		CommandeFacade commande = gest.ajouterCommande(new Long(1), new Long(1), listeLivreCommandee);
		
		commande.calculMontant();
		double montantAchat = commande.getMontant();
		
		System.out.println("Compte client : " + client.getFonds());
		System.out.println("Montant achat : " + montantAchat);
		System.out.println(checkCommande(new Long(1), new Long(1)));
		
		/*
		 * Regler commande
		 
		effectuerPaiement(new Long(1), new Long(1));
		System.out.println("Nouveau Compte client : " + client.getFonds());
		
		System.out.println("End connection !");
	}*/
}
