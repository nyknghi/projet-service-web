package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.*;

@Entity
@Table(name="Catalogue")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Catalogue extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCatalogue;
	@Column
	private String intitule;
	
	public Catalogue() throws RemoteException {}

	public Catalogue(String intitule) throws RemoteException {
		this.intitule = intitule;
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
