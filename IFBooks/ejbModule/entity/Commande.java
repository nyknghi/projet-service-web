package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table (name="Commande", uniqueConstraints=@UniqueConstraint(columnNames={"client_idclient","livre_idlivre"}))
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCommande;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn (referencedColumnName="idClient")
	private Client client;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn (referencedColumnName="idLivre")
	private Livre livre;
	@Column
	private int quantite;
	@Column
	private double montant;
	@Column
	private Date dateCommande;
	public enum Etape {
		CREEE, LIVREE, ANNULEE 
	}
	@Column
	private Etape etape;
	
	public Commande(){}

	public Commande(Client client, Livre livre, int quantite) {
		this.client = client;
		this.livre = livre;
		this.quantite = quantite;
		this.dateCommande = new Date();
		this.etape = Etape.CREEE;		
		calculMontant();
	}
	
	public void calculMontant(){
		this.montant = livre.getPrix()*quantite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}
	
	
}
