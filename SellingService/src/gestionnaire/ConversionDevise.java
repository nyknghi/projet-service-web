/**
 * ConversionDevise.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gestionnaire;

public interface ConversionDevise extends java.rmi.Remote {
    public double convertir(java.lang.String source, java.lang.String cible, double montant) throws java.rmi.RemoteException;
}
