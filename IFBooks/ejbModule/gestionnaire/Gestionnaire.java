package gestionnaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Auteur;
import entity.Livre;
import entity.SousCatalogue;

public class Gestionnaire extends UnicastRemoteObject implements IGestionnaire{

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	EntityManager em;
	
	static Context ctx;
	
	private static Gestionnaire instance;
	
	public Gestionnaire() throws RemoteException {
		super();
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("SampleUnit");
	    em = emf.createEntityManager();
	    createContext();*/
	}

	public static Gestionnaire getInstance() throws RemoteException{
		if (instance==null){
			try {
				ctx = new InitialContext();
				ctx.addToEnvironment(InitialContext.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");
				ctx.addToEnvironment(InitialContext.URL_PKG_PREFIXES,
						"org.jboss.naming:org.jnp.interfaces");
				ctx.addToEnvironment(InitialContext.PROVIDER_URL,
						"jnp://localhost:1099");
				instance = (Gestionnaire) ctx.lookup("Gestionnaire/Remote");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} 
		return instance;
	}
	
/*
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

	@SuppressWarnings("unchecked")
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

	@Override
	public Auteur rechercherAuteur(long idAuteur) throws RemoteException {
		return em.find(Auteur.class, idAuteur);
	}
*/
	@Override
	public void ajouterLivre(long id, String titre, int nbDisponibles,
			double prix, Auteur auteur, SousCatalogue catalogue)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerLivre(Livre livre) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterSousCatalogue(String intitule) throws RemoteException {
		SousCatalogue sc = new SousCatalogue(intitule);
		em.persist(sc);
	}

	@Override
	public Map<Long, Livre> rechercherParTitre(String titre)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, Livre> rechercherParAuteur(long idAuteur)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estDisponible(long idLivre) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
