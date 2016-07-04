/*
 * Clase Resultados en package modelo
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author MPort y SGamarra
 */
public class Resultados {

    // Declaramos las variables de la clase Resultados
    private int idresultados;
    private Ruta ruta;
    private User user;
    private int horas;
    private int minutos;
    private double velmedia;
   

    

    public Resultados() {
        ruta = new Ruta();
        user = new User();
    }

    public static final String PROP_VELMEDIA = "velmedia";

    public double getVelmedia() {
        double minutoshora = 0;
        double media = 0;
        minutoshora = (((double) horas * 60) + (double) minutos) / 60;
        media = ruta.getDistancia() / minutoshora;
        return media;
    }

    @Override
    public String toString() {
        return "Resultados{" + "idresultados=" + idresultados + ", ruta=" + ruta + ", user=" + user + ", horas=" + horas + ", minutos=" + minutos + ", velmedia=" + velmedia + ", propertyChangeSupport=" + propertyChangeSupport + '}';
    }

    

    public void setVelmedia(double velmedia) {
        double oldVelmedia = this.velmedia;
        this.velmedia = velmedia;
        propertyChangeSupport.firePropertyChange(PROP_VELMEDIA, oldVelmedia, velmedia);
    }

    public static final String PROP_MINUTOS = "minutos";

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        int oldMinutos = this.minutos;
        this.minutos = minutos;
        propertyChangeSupport.firePropertyChange(PROP_MINUTOS, oldMinutos, minutos);
    }

    public static final String PROP_HORAS = "horas";

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        int oldHoras = this.horas;
        this.horas = horas;
        propertyChangeSupport.firePropertyChange(PROP_HORAS, oldHoras, horas);
    }

    public static final String PROP_USER = "user";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        User oldUser = this.user;
        this.user = user;
        propertyChangeSupport.firePropertyChange(PROP_USER, oldUser, user);
    }

    public static final String PROP_RUTA = "ruta";

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        Ruta oldRuta = this.ruta;
        this.ruta = ruta;
        propertyChangeSupport.firePropertyChange(PROP_RUTA, oldRuta, ruta);
    }

    public static final String PROP_IDRESULTADOS = "idresultados";

    public int getIdresultados() {
        return idresultados;
    }

    public void setIdresultados(int idresultados) {
        int oldIdresultados = this.idresultados;
        this.idresultados = idresultados;
        propertyChangeSupport.firePropertyChange(PROP_IDRESULTADOS, oldIdresultados, idresultados);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
