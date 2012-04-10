package gestionnaire;

import java.rmi.RemoteException;

public class GesBooksProxy implements gestionnaire.GesBooks {
  private String _endpoint = null;
  private gestionnaire.GesBooks gesBooks = null;
  
  public GesBooksProxy() {
    _initGesBooksProxy();
  }
  
  public GesBooksProxy(String endpoint) {
    _endpoint = endpoint;
    _initGesBooksProxy();
  }
  
  private void _initGesBooksProxy() {
    try {
      gesBooks = (new gestionnaire.GesBooksServiceLocator()).getGesBooks();
      if (gesBooks != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)gesBooks)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)gesBooks)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (gesBooks != null)
      ((javax.xml.rpc.Stub)gesBooks)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gestionnaire.GesBooks getGesBooks() {
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks;
  }

@Override
public void viderPanier() throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	gesBooks.viderPanier();
}

@Override
public double prixDuLivre(long idLivre) throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	return gesBooks.prixDuLivre(idLivre);
}

@Override
public boolean effectuerPaiement(long idClient) throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	return gesBooks.effectuerPaiement(idClient);
}

@Override
public void ajouterLivrePanier(long idLivre, int qteACommande)
		throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	gesBooks.ajouterLivrePanier(idLivre, qteACommande);
}

@Override
public void setDeviseEncours(String deviseEncours) throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	gesBooks.setDeviseEncours(deviseEncours);
}

@Override
public boolean estDisponible(long idLivre) throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	return gesBooks.estDisponible(idLivre);
}

@Override
public String getDeviseEncours() throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	return gesBooks.getDeviseEncours();
}

@Override
public void suppLivreDansPanier(long idLivre) throws RemoteException {
	if (gesBooks == null)
		_initGesBooksProxy();
	gesBooks.suppLivreDansPanier(idLivre);
}

@Override
public void connecter() throws RemoteException {
	// TODO Auto-generated method stub
	
}
  
  
}