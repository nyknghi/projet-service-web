package gestionnaire;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

import facade.ClientFacade;
import facade.CommandeFacade;
import facade.LivreFacade;

public class GestionnaireServeur {
	static IGestionnaire gest;
	
	public GestionnaireServeur(){
		Util.execPath();
		try {
			Util.PATH_USER_DIR=System.getProperty("user.dir");
			System.setProperty("java.security.policy", Util.PATH_POLICY);
			System.setProperty("java.rmi.server.codebase", Util.PATH_CODEBASE);
			System.out.println(Util.PATH_CODEBASE);
		
			Registry r = LocateRegistry.getRegistry();		
			
			if (System.getSecurityManager() == null) 
				System.setSecurityManager(new RMISecurityManager());
						
			gest = new Gestionnaire();
			r.rebind("rmi://localhost/GestionnaireServeur", gest);			
			
			creerOrdinateur();
			creerBD();
			
			System.out.println("Server started !");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new GestionnaireServeur();		
	}
	
	public void creerOrdinateur() throws RemoteException{
		Ordinateur ord1 = new Ordinateur(1);
		Ordinateur ord2 = new Ordinateur(2);
		Ordinateur ord3 = new Ordinateur(3);
		
		ord1.subscribeToObservee();
		ord2.subscribeToObservee();
		ord3.subscribeToObservee();
	}
	
	public void creerBD() throws RemoteException{
		gest.ajouterSousCatalogue(1, "Gestion", 1);
		gest.ajouterSousCatalogue(2, "Informatique", 2);
		
		gest.ajouterAuteur(1, "Steven");
		ClientFacade client = gest.ajouterClient(1, "Client 1", "thierry", "thierry","	AUTEUR");
		client.ajouterFonds(1000);
		gest.ajouterAuteur(2, "Georges");
		ClientFacade client2 = gest.ajouterClient(2, "Client 2", "nghi", "nghi","	AUTEUR");
		client2.ajouterFonds(1000);
		
		gest.ajouterLivre(1, "Finance d'entreprise", 3, 25.0, 1, 1,"Livre fait pour des etudiants");
		gest.ajouterLivre(2, "Crise financiere et Balse III", 3, 15.5, 1, 1,"Livre ecrit pour professionnel");
		gest.ajouterLivre(3, "Programmation C++", 5, 12.0, 2, 2,"Livre ecrit pour professionnel");
		
		LivreFacade finance = (LivreFacade) gest.rechercherParId(new Long(1));
		LivreFacade eco = (LivreFacade) gest.rechercherParId(new Long(2));
		LivreFacade info = (LivreFacade) gest.rechercherParId(new Long(3));
		
		System.out.println(finance.afficher());
		System.out.println(eco.afficher());
		System.out.println(info.afficher());
		
		// Creation d'une commande
		 
		Map<Integer, Long> listeLivreCommandee = new HashMap<Integer, Long>();
		listeLivreCommandee.put(new Integer(1), new Long(1));
		listeLivreCommandee.put(new Integer(3), new Long(2));
		
		CommandeFacade commande = gest.ajouterCommande(new Long(1), new Long(1), listeLivreCommandee);
		
		commande.calculMontant();
		double montantAchat = commande.getMontant();
		
		System.out.println("Compte client : " + client.getFonds());
		System.out.println("Montant achat : " + montantAchat);
	}
}

