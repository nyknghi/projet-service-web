package gestionnaire;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.rpc.ServiceException;

import facade.AuteurFacade;
import facade.Books;
import facade.ClientFacade;
import facade.LivreFacade;

public class GesBooks {

	public GesBooks() {	}
	static IGestionnaire gest;
	static ConversionDevise bankService;
	static PaiementService paiementService;
	static Map <Integer, Long> panier = new HashMap<Integer, Long>();
	static String deviseEncours;
	public static ClientFacade client;
	public static AuteurFacade auteur;
	/*public static Client clientFac;
	public static Auteur auteurFac;*/

	public String getDeviseEncours() {
		return deviseEncours;
	}

	public void setDeviseEncours(String deviseEncours) {
		GesBooks.deviseEncours = deviseEncours;
	}

	public static void connecter(){
		System.setProperty("java.rmi.server.codebase", "file:///criounix/share.nfs/users/student/21102208/workspace_helios_ws/IF_Books/src/gestionnaire/");
		System.setProperty("java.security.policy", "/criounix/share.nfs/users/student/21102208/workspace_helios_ws/IF_Books/src/sec.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		//System.setProperty("java.rmi.server.codebase", "file:///criounix/share.nfs/users/student/21102208/workspace_helios_ws/IF_Books/src/gestionnaire/");
		try {
			Registry r = LocateRegistry.getRegistry();
			gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		try {
			bankService = (ConversionDevise) new ConversionDeviseServiceLocator().getConversionDevise();
			paiementService = (PaiementService) new PaiementServiceServiceLocator().getPaiementService();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public double prixDuLivre(long idLivre) throws RemoteException{
		GesBooks.connecter();
		LivreFacade livre = gest.rechercherParId(idLivre);
		if(livre != null)
		{
			if (deviseEncours.toUpperCase().equals("EUR"))
				return livre.getPrix();
			else
				return bankService.convertir("EUR", deviseEncours, livre.getPrix());
		}
		else
			return 0;
	}

	public boolean estDisponible(long idLivre) throws RemoteException{
		GesBooks.connecter();
		return gest.estDisponible(idLivre);
	}

	public void ajouterLivrePanier(long idLivre, int qteACommande){
		if(panier.containsKey(idLivre)){
			panier.remove(idLivre);
		}
		panier.put(qteACommande, idLivre);
	}

	/*public Map<Integer, Long> recupererPanier(){
		return panier;
	}*/

	public void suppLivreDansPanier(long idLivre){
		for(Entry<Integer, Long> pan: panier.entrySet()){
			if(pan.getValue().equals(idLivre)){
				panier.remove(pan.getKey());
				break;
			}
		}
	}

	public void viderPanier(){
		panier.clear();
	}

	public boolean effectuerPaiement(long idClient){
		GesBooks.connecter();
		try {
			double montant = 0;
			for(Entry<Integer, Long> pan: panier.entrySet()){
				LivreFacade livre = gest.rechercherParId(pan.getValue());
				montant = montant + livre.getPrix()*pan.getKey();
			}
			if(paiementService.isFondsDispo(idClient, montant)){
				GesBooks.connecter();
				long idCommande = gest.getLastKeyCommande();
				gest.ajouterCommande(idCommande, idClient, panier);

				paiementService.effectuerPaiement(idClient, idCommande);
				return true;
			}
			else
				return false;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean connexion(String login, String pwd){
		try {
			connecter();
			client =  gest.rechercherClientParLogin(login, pwd);
			if(client != null){
				if(client.getType().equals("AUTEUR")){
					auteur = gest.rechercherAuteurParId(client.getIdClient());
				}
				return true;
			}
			else{
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	//<ns1:parameter name="scope" value="Application"/>

	public String[] getClientInformation(){
		try{
			if(client.getType().equals("AUTEUR")){
				String[] clientinfo = new String[3];
				clientinfo[2] = auteur.getLogin();
				clientinfo[1] = auteur.getType();
				clientinfo[0] = new String(auteur.getIdAuteur() + "");
				return clientinfo;
			}
			else{
				String[] clientinfo = new String[3];
				clientinfo[2] = client.getLogin();
				clientinfo[1] = client.getType();
				clientinfo[0] = new String(client.getIdClient() + "");
				return clientinfo;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Books[] getFindsBooks(String title, String author, String categorie){
		try {
			connecter();
			if(categorie.equals("")){
				if(!title.equals("")){
					Map<Long, LivreFacade> livres = gest.rechercherParTitre(title);
					Books[] LesLivres = null;
					if(livres.size() > 0)
						LesLivres = new Books[livres.size()];
					int i = 0;
					for(Entry <Long, LivreFacade> entry : livres.entrySet()) {
						LivreFacade liv = entry.getValue();
						AuteurFacade auteur = liv.getAuteur();
						Books b = new Books();
						b.setDescription(liv.getDescription());
						b.setNbDispo(liv.getNbDisponibles());
						b.setNomAuteur(auteur.getNom());
						b.setPrix(liv.getPrix());
						b.setTitre(liv.getTitre());
						LesLivres[i] = b;
						i++;
					}
					return LesLivres;
				}
				else{
					if(!author.equals("")){
						Map<Long, LivreFacade> livres = gest.rechercherParNomDeAuteur(author);
						Books[] LesLivres = null;
						if(livres.size() > 0)
							LesLivres = new Books[livres.size()];
						int i = 0;
						for(Entry <Long, LivreFacade> entry : livres.entrySet()) {
							LivreFacade liv = entry.getValue();
							AuteurFacade auteur = liv.getAuteur();
							Books b = new Books();
							b.setDescription(liv.getDescription());
							b.setNbDispo(liv.getNbDisponibles());
							b.setNomAuteur(auteur.getNom());
							b.setPrix(liv.getPrix());
							b.setTitre(liv.getTitre());
							LesLivres[i] = b;
							i++;
						}
						return LesLivres;
					}
					return null;
				}
			}
			else{
				Map<Long, LivreFacade> livres = gest.rechercherParNomDeCategorie(categorie);
				Books[] LesLivres = new Books[1];
				if(livres.size() > 0)
					LesLivres = new Books[livres.size()];
				int i = 0;
				for(Entry <Long, LivreFacade> entry : livres.entrySet()) {
					LivreFacade liv = entry.getValue();
					AuteurFacade auteur = liv.getAuteur();
					Books b = new Books();
					b.setDescription(liv.getDescription());
					b.setNbDispo(liv.getNbDisponibles());
					b.setNomAuteur(auteur.getNom());
					b.setPrix(liv.getPrix());
					b.setTitre(liv.getTitre());
					LesLivres[i] = b;
					i++;
				}
				return LesLivres;
				/*Books b = new Books();
				 b.setDescription("mmusee");
				 b.setNbDispo(livres.size());
				 Books[] LesLivres = new Books[1];
				 LesLivres[0] = b;
				return LesLivres;*/
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}


