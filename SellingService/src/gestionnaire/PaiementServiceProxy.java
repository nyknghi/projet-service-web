package gestionnaire;

public class PaiementServiceProxy implements gestionnaire.PaiementService {
  private String _endpoint = null;
  private gestionnaire.PaiementService paiementService = null;
  
  public PaiementServiceProxy() {
    _initPaiementServiceProxy();
  }
  
  public PaiementServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPaiementServiceProxy();
  }
  
  private void _initPaiementServiceProxy() {
    try {
      paiementService = (new gestionnaire.PaiementServiceServiceLocator()).getPaiementService();
      if (paiementService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)paiementService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)paiementService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (paiementService != null)
      ((javax.xml.rpc.Stub)paiementService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gestionnaire.PaiementService getPaiementService() {
    if (paiementService == null)
      _initPaiementServiceProxy();
    return paiementService;
  }
  
  public boolean checkCommande(long idClient, long idCommande) throws java.rmi.RemoteException{
    if (paiementService == null)
      _initPaiementServiceProxy();
    return paiementService.checkCommande(idClient, idCommande);
  }
  
  public void effectuerPaiement(long idClient, long idCommande) throws java.rmi.RemoteException{
    if (paiementService == null)
      _initPaiementServiceProxy();
    paiementService.effectuerPaiement(idClient, idCommande);
  }
  
  public void connecter() throws java.rmi.RemoteException{
    if (paiementService == null)
      _initPaiementServiceProxy();
    paiementService.connecter();
  }
  
  public boolean isFondsDispo(long idClient, double montant) throws java.rmi.RemoteException{
    if (paiementService == null)
      _initPaiementServiceProxy();
    return paiementService.isFondsDispo(idClient, montant);
  }
  
  
}