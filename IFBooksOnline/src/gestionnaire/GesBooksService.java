/**
 * GesBooksService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gestionnaire;

public interface GesBooksService extends javax.xml.rpc.Service {
    public java.lang.String getGesBooksAddress();

    public gestionnaire.GesBooks getGesBooks() throws javax.xml.rpc.ServiceException;

    public gestionnaire.GesBooks getGesBooks(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
