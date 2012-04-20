package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SousCatalogue extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	private long idCatalogue;
	private String intitule;
	
	private Map<Long,Livre> livres = new HashMap<Long,Livre>();
	
	public SousCatalogue() throws RemoteException{
		super();
	}
	
	public SousCatalogue(long id, String intitule) throws RemoteException{
		this.idCatalogue = id;
		this.intitule = intitule;
	}

	public Map<Long,Livre> getLivres() {
		return livres;
	}

	public void setLivres(Map<Long,Livre> livres) {
		this.livres = livres;
	}
	
	public void ajouterLivre(Livre livre){
		this.livres.put(livre.getIdLivre(), livre);
	}
	
	public Livre getLivreParId(long idLivre){
		return livres.get(idLivre);
	}
	
	public Map<Long,Livre> getLivreByAuteur(Auteur auteur){
		Map<Long, Livre> res = new HashMap<Long, Livre>();
		for(Entry <Long, Livre> entry : livres.entrySet()) {
			Livre liv = entry.getValue();
			if (liv.getAuteur().equals(auteur))
				res.put(liv.getIdLivre(), liv);
		}
		return res;
	}
	
	public Map<Long,Livre> getLivreByTitre(String titre){
		Map<Long, Livre> res = new HashMap<Long, Livre>();
		for(Entry <Long, Livre> entry : livres.entrySet()) {
			Livre liv = entry.getValue();
			if (liv.getTitre().contains(titre)){
				res.put(liv.getIdLivre(), liv);
			}
		}
		return res;
	}
	
	public void removeLivre(long idLivre){
		this.livres.remove(idLivre);
	}

	public long getIdCatalogue() {
		return idCatalogue;
	}

	public void setIdCatalogue(long idCatalogue) {
		this.idCatalogue = idCatalogue;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
}
