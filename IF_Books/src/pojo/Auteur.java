package pojo;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import facade.AuteurFacade;
import facade.LivreFacade;

public class Auteur extends Client implements AuteurFacade{
	private static final long serialVersionUID = 1L;
	private long idAuteur;
	private String nom;
	private Set<Livre> livres = new HashSet<Livre>();
	
	public Auteur() throws RemoteException{}
	
	public Auteur(long idAuteur, String nom) throws RemoteException{
		this.idAuteur = idAuteur;
		this.nom = nom;
	}
	
	public void envoyerManuscrit(Livre livre, SousCatalogue sc){
		ajouterLivre(livre);
		sc.ajouterLivre(livre);
		livre.setDiffuse(false);
	}

	public void modifierManuscrit(Livre livre){
		boolean trouve=false;
		for (Livre liv : livres){
			if (liv.getIdLivre()==livre.getIdLivre()){
				trouve=true;
				liv.setDescription(livre.getDescription());
				liv.setTitre(livre.getTitre());
			}
		}
		if (!trouve) System.out.println("Pas droit de modification");
	}
	
	public long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(long idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	public void ajouterLivre(Livre livre){
		this.livres.add(livre);
	}
	
	public void removeLivre(long idLivre){
		this.livres.remove(idLivre);
	}

	@Override
	public Set<LivreFacade> getLivreFacade() {
		Set<LivreFacade> res = new HashSet<LivreFacade>();
		res.addAll(getLivres());
		return res;
	}
}
