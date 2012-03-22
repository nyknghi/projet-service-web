package gestionnaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Auteur;
import entity.Livre;
import entity.SousCatalogue;

@Stateless
public class Gestionnaire extends UnicastRemoteObject implements IGestionnaire{
	@PersistenceContext
	EntityManager em;
	
	protected Gestionnaire() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void ajouterLivre(String titre, int nbDisponibles, double prix,
			Auteur auteur, SousCatalogue catalogue) throws RemoteException {
		Livre livre = new Livre(titre, nbDisponibles, prix, auteur, catalogue);
		em.persist(livre);		
	}

	@Override
	public void supprimerLivre(long idLivre) throws RemoteException {
		Livre livre = em.find(Livre.class, idLivre);
		em.remove(livre);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Livre> rechercherParTitre(String titre) throws RemoteException {
		//Set<Livre> livres = new HashSet<Livre>();
		Query query = em.createNamedQuery("Select l from Livre l where l.titre= :titre");
		query.setParameter("titre", titre);
		return (Set<Livre>) query.getResultList();
	}

	@Override
	public Set<Livre> rechercherParAuteur(long idAuteur) throws RemoteException {
		Auteur auteur = em.find(Auteur.class, idAuteur);
		Query query = em.createNamedQuery("Select l from Livre l where l.auteur = :auteur");
		query.setParameter("auteur", auteur);
		return (Set<Livre>) query.getResultList();
	}

	@Override
	public boolean estDisponible(long idLivre) throws RemoteException {
		Livre livre = em.find(Livre.class, idLivre);
		return !(livre.getNbDisponibles()==0);
	}
	
}
