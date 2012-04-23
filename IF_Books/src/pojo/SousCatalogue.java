package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import facade.LivreFacade;
import facade.SousCatalogueFacade;

public class SousCatalogue extends UnicastRemoteObject implements SousCatalogueFacade{
	private static final long serialVersionUID = 1L;
	private long idCatalogue;
	private String intitule;
	
	private Map<Long,LivreFacade> livres = new HashMap<Long,LivreFacade>();
	
	public SousCatalogue() throws RemoteException{
		super();
	}
	
	public SousCatalogue(long id, String intitule) throws RemoteException{
		this.idCatalogue = id;
		this.intitule = intitule;
	}

	public Map<Long,LivreFacade> getLivres() {
		return livres;
	}

	public void setLivres(Map<Long,LivreFacade> livres) {
		this.livres = livres;
	}
	
	public void ajouterLivre(LivreFacade livre) throws RemoteException{
		this.livres.put(livre.getIdLivre(), livre);
	}
	
	public LivreFacade getLivreParId(long idLivre){
		return livres.get(idLivre);
	}
	
	public Map<Long,LivreFacade> getLivreByAuteur(Auteur auteur) throws RemoteException{
		Map<Long, LivreFacade> res = new HashMap<Long, LivreFacade>();
		for(Entry <Long, LivreFacade> entry : livres.entrySet()) {
			LivreFacade liv = entry.getValue();
			if (liv.getAuteur().equals(auteur))
				res.put(liv.getIdLivre(), liv);
		}
		return res;
	}
	
	public Map<Long,LivreFacade> getLivreByNomSousCat(String categorie) throws RemoteException{
		Map<Long, LivreFacade> res = new HashMap<Long, LivreFacade>();
		if(this.getIntitule().contains(categorie))
			return this.getLivres();
		return res;
	}
	
	public Map<Long,LivreFacade> getLivreByTitre(String titre) throws RemoteException{
		Map<Long, LivreFacade> res = new HashMap<Long, LivreFacade>();
		for(Entry <Long, LivreFacade> entry : livres.entrySet()) {
			LivreFacade liv = entry.getValue();
			if (liv.getTitre().contains(titre)){
				res.put(liv.getIdLivre(), liv);
			}
		}
		return res;
	}
	
	public Map<Long,LivreFacade> getLivreByNomAuteur(String nomAuteur) throws RemoteException{
		Map<Long, LivreFacade> res = new HashMap<Long, LivreFacade>();
		for(Entry <Long, LivreFacade> entry : livres.entrySet()) {
			LivreFacade liv = entry.getValue();
			if (liv.getAuteur().getNom().contains(nomAuteur)){
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
