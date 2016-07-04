/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaRuta {
    
        private ObservableList<Ruta> lista;
        
        public ListaRuta(){
            lista = ObservableCollections.observableList(new ArrayList<Ruta>());
        }
        
        public void altaRuta(Ruta r){
            lista.add(r);
        }
        
        public void bajaRuta(Ruta r){
            lista.remove(r);
        }
        
        

    public static final String PROP_LISTA = "lista";

    public ObservableList<Ruta> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Ruta> lista) {
        ObservableList<Ruta> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
