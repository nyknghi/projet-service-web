/**
 * GesBooks.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gestionnaire;

public interface GesBooks extends java.rmi.Remote {
    public void viderPanier() throws java.rmi.RemoteException;
    public double prixDuLivre(long idLivre) throws java.rmi.RemoteException;
    public boolean effectuerPaiement(long idClient) throws java.rmi.RemoteException;
    public void ajouterLivrePanier(long idLivre, int qteACommande) throws java.rmi.RemoteException;
    public void setDeviseEncours(java.lang.String deviseEncours) throws java.rmi.RemoteException;
    public boolean estDisponible(long idLivre) throws java.rmi.RemoteException;
    public java.lang.String getDeviseEncours() throws java.rmi.RemoteException;
    public void suppLivreDansPanier(long idLivre) throws java.rmi.RemoteException;
    public void connecter() throws java.rmi.RemoteException;
}
