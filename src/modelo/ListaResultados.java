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
public class ListaResultados {
    
        private ObservableList<Resultados> lista;
        
        public ListaResultados(){
            lista=ObservableCollections.observableList(new ArrayList<Resultados>());
        }
        
        public void altaResultados(Resultados r){
        lista.add(r);
    }
        
        public void bajaResultados (Resultados r){
            lista.remove(r);
        }

    @Override
    public String toString() {
        return "ListaResultados{" + "lista=" + lista + ", propertyChangeSupport=" + propertyChangeSupport + '}';
    }
        
        
        
        

    public static final String PROP_LISTA = "lista";

    public ObservableList<Resultados> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Resultados> lista) {
        ObservableList<Resultados> oldLista = this.lista;
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
