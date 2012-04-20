package gestionnaire;

public class ConversionDeviseProxy implements gestionnaire.ConversionDevise {
  private String _endpoint = null;
  private gestionnaire.ConversionDevise conversionDevise = null;
  
  public ConversionDeviseProxy() {
    _initConversionDeviseProxy();
  }
  
  public ConversionDeviseProxy(String endpoint) {
    _endpoint = endpoint;
    _initConversionDeviseProxy();
  }
  
  private void _initConversionDeviseProxy() {
    try {
      conversionDevise = (new gestionnaire.ConversionDeviseServiceLocator()).getConversionDevise();
      if (conversionDevise != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)conversionDevise)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)conversionDevise)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (conversionDevise != null)
      ((javax.xml.rpc.Stub)conversionDevise)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gestionnaire.ConversionDevise getConversionDevise() {
    if (conversionDevise == null)
      _initConversionDeviseProxy();
    return conversionDevise;
  }
  
  public double convertir(java.lang.String source, java.lang.String cible, double montant) throws java.rmi.RemoteException{
    if (conversionDevise == null)
      _initConversionDeviseProxy();
    return conversionDevise.convertir(source, cible, montant);
  }
  
  
}