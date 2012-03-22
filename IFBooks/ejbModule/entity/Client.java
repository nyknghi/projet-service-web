package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idClient;
	@Column
	private String nom;
	@Column
	private String login;
	@Column
	private String mdp;
	@Column
	private double fonds;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="client")
	private Set<Commande> commandes = new HashSet<Commande>();
	
	public Client(){}

	public Client(String nom, String login, String mdp) {
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
		this.fonds = 5.0;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public double getFonds() {
		return fonds;
	}

	public void setFonds(double fonds) {
		this.fonds = fonds;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
	public void ajouterCommande(Commande commande){
		this.commandes.add(commande);
	}
}
