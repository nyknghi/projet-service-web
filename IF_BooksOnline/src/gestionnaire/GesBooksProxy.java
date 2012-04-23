package gestionnaire;

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
  
  public java.lang.String getDeviseEncours() throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.getDeviseEncours();
  }
  
  public void setDeviseEncours(java.lang.String deviseEncours) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    gesBooks.setDeviseEncours(deviseEncours);
  }
  
  public void connecter() throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    gesBooks.connecter();
  }
  
  public double prixDuLivre(long idLivre) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.prixDuLivre(idLivre);
  }
  
  public boolean estDisponible(long idLivre) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.estDisponible(idLivre);
  }
  
  public void ajouterLivrePanier(long idLivre, int qteACommande) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    gesBooks.ajouterLivrePanier(idLivre, qteACommande);
  }
  
  public void suppLivreDansPanier(long idLivre) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    gesBooks.suppLivreDansPanier(idLivre);
  }
  
  public void viderPanier() throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    gesBooks.viderPanier();
  }
  
  public boolean effectuerPaiement(long idClient) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.effectuerPaiement(idClient);
  }
  
  public boolean connexion(java.lang.String login, java.lang.String pwd) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.connexion(login, pwd);
  }
  
  public java.lang.String[] getClientInformation() throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.getClientInformation();
  }
  
  public facade.Books[] getFindsBooks(java.lang.String title, java.lang.String author, java.lang.String categorie) throws java.rmi.RemoteException{
    if (gesBooks == null)
      _initGesBooksProxy();
    return gesBooks.getFindsBooks(title, author, categorie);
  }
  
  
}