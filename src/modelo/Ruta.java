/*
 * Clase Ruta en package modelo
*/
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author MPort y SGamarra
 */
public class Ruta {
    // Declaramos las variables de la clase Ruta
    private int idruta;
    private String nomruta;
    private double distancia;
    private int desnivell;
    private int dificultat;
    
    
    
    // Constructor de la clase
    public Ruta() {
        nomruta = "";
    }
    
    //tostring per mostrar els camps que es veuran a l'hora d'introduir un resultat

    @Override
    public String toString() {
        return nomruta + ", Kms: " + distancia + ", Dificultat: " + dificultat;
    }
    
    
    
    // Bounds
    public static final String PROP_DIFICULTAT = "dificultat";

    public int getDificultat() {
        return dificultat;
    }

    public void setDificultat(int dificultat) {
        int oldDificultat = this.dificultat;
        this.dificultat = dificultat;
        propertyChangeSupport.firePropertyChange(PROP_DIFICULTAT, oldDificultat, dificultat);
    }


    public static final String PROP_DESNIVELL = "desnivell";

    public int getDesnivell() {
        return desnivell;
    }

    public void setDesnivell(int desnivell) {
        int oldDesnivell = this.desnivell;
        this.desnivell = desnivell;
        propertyChangeSupport.firePropertyChange(PROP_DESNIVELL, oldDesnivell, desnivell);
    }


    public static final String PROP_DISTANCIA = "distancia";

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        double oldDistancia = this.distancia;
        this.distancia = distancia;
        propertyChangeSupport.firePropertyChange(PROP_DISTANCIA, oldDistancia, distancia);
    }

    
    
    public static final String PROP_NOMRUTA = "nomruta";

    public String getNomruta() {
        return nomruta;
    }

    public void setNomruta(String nomruta) {
        String oldNomruta = this.nomruta;
        this.nomruta = nomruta;
        propertyChangeSupport.firePropertyChange(PROP_NOMRUTA, oldNomruta, nomruta);
    }

    
    
    
    public static final String PROP_IDRUTA = "idruta";

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        int oldIdruta = this.idruta;
        this.idruta = idruta;
        propertyChangeSupport.firePropertyChange(PROP_IDRUTA, oldIdruta, idruta);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
    
}
