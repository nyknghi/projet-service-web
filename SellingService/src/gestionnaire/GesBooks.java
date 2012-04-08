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

import devise.ConversionDeviseServiceLocator;
import facade.LivreFacade;

public class GesBooks {

	public GesBooks() {	}
	static  IGestionnaire gest;
	static ConversionDevise bankService;
	static PaiementService paiementService;
	static Map <Integer, Long> panier = new HashMap<Integer, Long>();
	static String deviseEncours;

	public String getDeviseEncours() {
		return deviseEncours;
	}

	public void setDeviseEncours(String deviseEncours) {
		GesBooks.deviseEncours = deviseEncours;
	}

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
		
		try {
			bankService = (ConversionDevise) new ConversionDeviseServiceLocator().getConversionDevise();
			paiementService = (PaiementService) new PaiementServiceServiceLocator().getPaiementService();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
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
}
