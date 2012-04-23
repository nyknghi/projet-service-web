/**
 * GesBooksServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gestionnaire;

public class GesBooksServiceLocator extends org.apache.axis.client.Service implements gestionnaire.GesBooksService {

    public GesBooksServiceLocator() {
    }


    public GesBooksServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GesBooksServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GesBooks
    private java.lang.String GesBooks_address = "http://localhost:8080/SellingService/services/GesBooks";

    public java.lang.String getGesBooksAddress() {
        return GesBooks_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GesBooksWSDDServiceName = "GesBooks";

    public java.lang.String getGesBooksWSDDServiceName() {
        return GesBooksWSDDServiceName;
    }

    public void setGesBooksWSDDServiceName(java.lang.String name) {
        GesBooksWSDDServiceName = name;
    }

    public gestionnaire.GesBooks getGesBooks() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GesBooks_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGesBooks(endpoint);
    }

    public gestionnaire.GesBooks getGesBooks(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gestionnaire.GesBooksSoapBindingStub _stub = new gestionnaire.GesBooksSoapBindingStub(portAddress, this);
            _stub.setPortName(getGesBooksWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGesBooksEndpointAddress(java.lang.String address) {
        GesBooks_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gestionnaire.GesBooks.class.isAssignableFrom(serviceEndpointInterface)) {
                gestionnaire.GesBooksSoapBindingStub _stub = new gestionnaire.GesBooksSoapBindingStub(new java.net.URL(GesBooks_address), this);
                _stub.setPortName(getGesBooksWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GesBooks".equals(inputPortName)) {
            return getGesBooks();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://gestionnaire", "GesBooksService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://gestionnaire", "GesBooks"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GesBooks".equals(portName)) {
            setGesBooksEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
