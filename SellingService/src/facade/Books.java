package facade;

public class Books {
	String nomAuteur;
	String titre;
	double prix;
	int nbDispo;
	String description;
	
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double d) {
		this.prix = d;
	}
	public int getNbDispo() {
		return nbDispo;
	}
	public void setNbDispo(int i) {
		this.nbDispo = i;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
