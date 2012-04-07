package pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class Catalogue extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	
	private Set<SousCatalogue> sous_cat = new HashSet<SousCatalogue>();
	private static Catalogue instance;
	
	public Catalogue() throws RemoteException {}

	public static Catalogue getInstance() throws RemoteException{
		if (instance==null){
			instance = new Catalogue();
		}
		return instance;
	}

	public void addSousCatalogue (SousCatalogue sc){
		this.sous_cat.add(sc);
	}
	
	public void removeSousCatalogue(SousCatalogue sc){
		this.sous_cat.remove(sc);
	}

	public SousCatalogue findSousCatalogue(long idCat){
		for (SousCatalogue sc : sous_cat){
			if (sc.getIdCatalogue() == idCat)
				return sc;
		}
		return null;
	}
	
	public Set<SousCatalogue> getSous_cat() {
		return sous_cat;
	}

	public void setSous_cat(Set<SousCatalogue> sous_cat) {
		this.sous_cat = sous_cat;
	}
}
