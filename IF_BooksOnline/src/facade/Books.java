/**
 * Books.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package facade;

public class Books  implements java.io.Serializable {
    private java.lang.String description;

    private int nbDispo;

    private java.lang.String nomAuteur;

    private double prix;

    private java.lang.String titre;

    public Books() {
    }

    public Books(
           java.lang.String description,
           int nbDispo,
           java.lang.String nomAuteur,
           double prix,
           java.lang.String titre) {
           this.description = description;
           this.nbDispo = nbDispo;
           this.nomAuteur = nomAuteur;
           this.prix = prix;
           this.titre = titre;
    }


    /**
     * Gets the description value for this Books.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Books.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the nbDispo value for this Books.
     * 
     * @return nbDispo
     */
    public int getNbDispo() {
        return nbDispo;
    }


    /**
     * Sets the nbDispo value for this Books.
     * 
     * @param nbDispo
     */
    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }


    /**
     * Gets the nomAuteur value for this Books.
     * 
     * @return nomAuteur
     */
    public java.lang.String getNomAuteur() {
        return nomAuteur;
    }


    /**
     * Sets the nomAuteur value for this Books.
     * 
     * @param nomAuteur
     */
    public void setNomAuteur(java.lang.String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }


    /**
     * Gets the prix value for this Books.
     * 
     * @return prix
     */
    public double getPrix() {
        return prix;
    }


    /**
     * Sets the prix value for this Books.
     * 
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }


    /**
     * Gets the titre value for this Books.
     * 
     * @return titre
     */
    public java.lang.String getTitre() {
        return titre;
    }


    /**
     * Sets the titre value for this Books.
     * 
     * @param titre
     */
    public void setTitre(java.lang.String titre) {
        this.titre = titre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Books)) return false;
        Books other = (Books) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.nbDispo == other.getNbDispo() &&
            ((this.nomAuteur==null && other.getNomAuteur()==null) || 
             (this.nomAuteur!=null &&
              this.nomAuteur.equals(other.getNomAuteur()))) &&
            this.prix == other.getPrix() &&
            ((this.titre==null && other.getTitre()==null) || 
             (this.titre!=null &&
              this.titre.equals(other.getTitre())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getNbDispo();
        if (getNomAuteur() != null) {
            _hashCode += getNomAuteur().hashCode();
        }
        _hashCode += new Double(getPrix()).hashCode();
        if (getTitre() != null) {
            _hashCode += getTitre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Books.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://facade", "Books"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://facade", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nbDispo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://facade", "nbDispo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomAuteur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://facade", "nomAuteur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://facade", "prix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://facade", "titre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
