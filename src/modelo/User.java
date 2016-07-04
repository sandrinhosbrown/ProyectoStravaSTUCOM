/*
 * Clase User en package modelo
*/
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author MPort y SGamarra
 */
public class User {
    // Declaramos las variables de la clase User
    private String nif;
    private String nom;
    private String cognom;
    private int pes;
    private int edad;
    
    //Constructor de la clase
    public User() {
        nif = "";
        nom = "";
        cognom = "";
        
    }
    
    //to string per decidir quins camps es veuran a la part de crear un nou resultat

    @Override
    public String toString() {
        return cognom + ", "+nom;
    }
    
    
    
    // Bounds
    public static final String PROP_EDAD = "edad";

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        int oldEdad = this.edad;
        this.edad = edad;
        propertyChangeSupport.firePropertyChange(PROP_EDAD, oldEdad, edad);
    }


    public static final String PROP_PES = "pes";

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        int oldPes = this.pes;
        this.pes = pes;
        propertyChangeSupport.firePropertyChange(PROP_PES, oldPes, pes);
    }


    public static final String PROP_COGNOM = "cognom";

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        String oldCognom = this.cognom;
        this.cognom = cognom;
        propertyChangeSupport.firePropertyChange(PROP_COGNOM, oldCognom, cognom);
    }

    
    public static final String PROP_NOM = "nom";

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        propertyChangeSupport.firePropertyChange(PROP_NOM, oldNom, nom);
    }

    public static final String PROP_NIF = "nif";

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        propertyChangeSupport.firePropertyChange(PROP_NIF, oldNif, nif);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
    
    
}
