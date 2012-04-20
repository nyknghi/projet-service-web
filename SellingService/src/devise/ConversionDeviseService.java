/**
 * ConversionDeviseService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package devise;

public interface ConversionDeviseService extends javax.xml.rpc.Service {
    public java.lang.String getConversionDeviseAddress();

    public devise.ConversionDevise getConversionDevise() throws javax.xml.rpc.ServiceException;

    public devise.ConversionDevise getConversionDevise(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
