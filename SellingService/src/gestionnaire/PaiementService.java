/**
 * PaiementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gestionnaire;

public interface PaiementService extends java.rmi.Remote {
    public void connecter() throws java.rmi.RemoteException;
    public boolean isFondsDispo(long idClient, double montant) throws java.rmi.RemoteException;
    public void effectuerPaiement(long idClient, long idCommande) throws java.rmi.RemoteException;
    public boolean checkCommande(long idClient, long idCommande) throws java.rmi.RemoteException;
}
