/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ListaResultados;
import modelo.ListaRuta;
import modelo.ListaUser;
import modelo.Resultados;
import modelo.Ruta;
import modelo.User;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @authors MPort y SGamarra
 */
public class ProyectoJDBC {

    private Connection conexion;

    //actualizar datos de ruta
    public void updateRuta(Ruta ruta) throws MyException {
        conectar();
        try {
            String update = "update ruta set nomruta = ?, distancia=?, desnivell =?, dificultat=? where idruta =?;";
            PreparedStatement ps = conexion.prepareStatement(update);
            ps.setString(1, ruta.getNomruta());
            ps.setDouble(2, ruta.getDistancia());
            ps.setInt(3, ruta.getDesnivell());
            ps.setInt(4, ruta.getDificultat());
            ps.setInt(5, ruta.getIdruta());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MyException("Error al actualizar datos " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    // actualizar datos de usuario
    public void updateUser(User user) throws MyException {
        conectar();
        try {
            String update = "update user set pes =?, edad=? where nif =?;";
            PreparedStatement ps = conexion.prepareStatement(update);
            ps.setInt(1, user.getPes());
            ps.setInt(2, user.getEdad());
            ps.setString(3, user.getNif());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MyException("Error al actualizar datos " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }

    }

    //borrar resultado
    public boolean borrarResultado(Resultados result) throws MyException {
        conectar();
        if (conexion != null) {
            try {
                String delete = "delete from resultados where idresultados =?;";
                System.out.println(result.getIdresultados());
                PreparedStatement ps = conexion.prepareStatement(delete);
                ps.setInt(1, result.getIdresultados());
                ps.executeUpdate();
                ps.close();
                return true;
            } catch (SQLException ex) {
                throw new MyException("Error a l'eliminar el resultat");
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }

    //borrar usuario
    public boolean borrarUser(User user) throws MyException {
        conectar();
        if (conexion != null) {
            try {
                String delete = "delete from user where nif =?;";
                PreparedStatement ps = conexion.prepareStatement(delete);
                ps.setString(1, user.getNif());
                ps.executeUpdate();
                ps.close();
                return true;
            } catch (SQLException ex) {
                throw new MyException("Error a l'eliminar l'usuari");
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }

    //borrar ruta
    public boolean borrarRuta(Ruta ruta) throws MyException {
        conectar();
        if (conexion != null) {
            try {
                String delete = "delete from ruta where idruta=?;";
                PreparedStatement ps = conexion.prepareStatement(delete);
                ps.setInt(1, ruta.getIdruta());
                ps.executeUpdate();
                ps.close();
                return true;
            } catch (SQLException ex) {
                throw new MyException("Error a l'eliminar la ruta");
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }

    //llistar RANKING
    public ListaResultados ranking(Ruta laRuta) throws MyException {
        ListaResultados result = new ListaResultados();

        conectar();
        try {
            String query = "SELECT * FROM proyecto.resultados join user join ruta on resultados.nif=user.nif where resultados.idruta ='" + laRuta.getIdruta() + "' group by user.nif having max(velmedia) order by velmedia desc;";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Resultados res = new Resultados();
                res.setIdresultados(rs.getInt("idresultados"));
                res.getUser().setNif(rs.getString("nif"));
                res.getUser().setNom(rs.getString("nom"));
                res.getUser().setCognom(rs.getString("cognoms"));
                res.getRuta().setNomruta(rs.getString("nomruta"));
                res.getRuta().setDistancia(rs.getDouble("distancia"));
                res.getRuta().setDesnivell(rs.getInt("desnivell"));
                res.getRuta().setDificultat(rs.getInt("dificultat"));
                res.setHoras(rs.getInt("hores"));
                res.setMinutos(rs.getInt("minuts"));
                res.setVelmedia(rs.getDouble("velmedia"));
                result.altaResultados(res);

            }

        } catch (SQLException ex) {
            throw new MyException("ERROR" + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }

        return result;
    }

    /*
     SELECT * FROM proyecto.resultados join user join ruta on resultados.nif=user.nif where resultados.idruta = 1241   
     group by user.nif having max(velmedia) order by velmedia desc;
     */
//llistar resultats
    public ListaResultados llistarResultats() throws MyException {
        ListaResultados resultats = new ListaResultados();
        conectar();
        try {
            String query = "SELECT * FROM resultados join user join ruta on resultados.nif=user.nif and resultados.idruta=ruta.idruta;";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Resultados r = new Resultados();
                r.setIdresultados(rs.getInt("idresultados"));
                r.getUser().setNif(rs.getString("nif"));
                r.getUser().setNom(rs.getString("nom"));
                r.getUser().setCognom(rs.getString("cognoms"));
                r.getRuta().setNomruta(rs.getString("nomruta"));
                r.getRuta().setDistancia(rs.getDouble("distancia"));
                r.getRuta().setDesnivell(rs.getInt("desnivell"));
                r.getRuta().setDificultat(rs.getInt("dificultat"));
                r.setHoras(rs.getInt("hores"));
                r.setMinutos(rs.getInt("minuts"));
                r.setVelmedia(rs.getDouble("velmedia"));
                resultats.altaResultados(r);
            }
        } catch (SQLException ex) {
            throw new MyException("Error al consultar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }

        return resultats;
    }

    //metode per a que apareguin les rutes quan donem d'alta un resultat
    public ListaRuta selectRuta() throws MyException {
        ListaRuta ruta = new ListaRuta();
        conectar();
        try {
            String query = "select * from ruta group by nomruta;";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Ruta r = new Ruta();
                r.setIdruta(rs.getInt("idruta"));
                r.setNomruta(rs.getString("nomruta"));
                r.setDistancia(rs.getDouble("distancia"));
                r.setDesnivell(rs.getInt("desnivell"));
                r.setDificultat(rs.getInt("dificultat"));
                ruta.altaRuta(r);
            }
        } catch (SQLException ex) {
            throw new MyException("Error al consultar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return ruta;

    }

    //quan donem d'alta un resultat amb aquesta consulta ens apareixen al combobox
    //els usuaris donats d'alta a la base de dades
    //amb un override a la clase User decidirem quins camps volem mostrar al combobox
    public ListaUser selectUser() throws MyException {
        ListaUser user = new ListaUser();
        conectar();
        try {
            String query = "select * from user order by cognoms;";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                User u = new User();
                u.setNif(rs.getString("nif"));
                u.setNom(rs.getString("nom"));
                u.setCognom(rs.getString("cognoms"));
                u.setPes(rs.getInt("pes"));
                u.setEdad(rs.getInt("edad"));
                user.altaUser(u);
            }

        } catch (SQLException ex) {

            throw new MyException("Error al consultar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return user;
    }

    public void insertResultat(Resultados res) throws MyException {
        conectar();

        try {
            String insert = "insert into resultados values ( null , ?, ?, ?, ?, ?);";
            PreparedStatement ps = conexion.prepareStatement(insert);

            ps.setString(1, res.getUser().getNif());
            ps.setInt(2, res.getRuta().getIdruta());
            ps.setInt(3, res.getHoras());
            ps.setInt(4, res.getMinutos());
            ps.setDouble(5, res.getVelmedia());
           
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new MyException("Error amb la inserció " + ex.getLocalizedMessage());

        } finally {

            desconectar();
        }

    }

    public void insertarUsuario(User usuario) throws MyException {
        existeUsuario(usuario);
        conectar();

        try {
            String insert = "insert into user values (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, usuario.getNif());
            ps.setString(2, usuario.getNom());
            ps.setString(3, usuario.getCognom());
            ps.setInt(4, usuario.getPes());
            ps.setInt(5, usuario.getEdad());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            throw new MyException("Error a l'insertar " + ex.getMessage());

        } finally {
            desconectar();
        }

    }

    public void insertarRuta(Ruta r) throws MyException {
        existeRuta(r);
        conectar();

        try {
            String insert = "insert into ruta values(?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setInt(1, r.getIdruta());
            ps.setString(2, r.getNomruta());
            ps.setDouble(3, r.getDistancia());
            ps.setInt(4, r.getDesnivell());
            ps.setInt(5, r.getDificultat());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            throw new MyException("Error a l'insertar " + ex.getMessage());

        } finally {
            desconectar();
        }

    }

    public void existeUsuario(User u) throws MyException {
        conectar();
        try {
            String query = "select * from user where nif='" + u.getNif() + "';";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                throw new MyException("Ja existeix un usuari amb aquest NIF");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            throw new MyException("Error a la consulta " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    public void existeRuta(Ruta r) throws MyException {
        conectar();
        try {
            String query = "select *from ruta where idruta='" + r.getIdruta() + "';";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                throw new MyException("Ja existeix una ruta amb aquest ID");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            throw new MyException("Error a la consulta " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    private void conectar() throws MyException {

        String url = "jdbc:mysql://localhost:3306/proyecto";
        String user = "root";
        String pass = "jeveris";
        try {
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            throw new MyException("Error amb la connexió " + ex.getLocalizedMessage());
        }
    }

    private void desconectar() throws MyException {
        try {
            conexion.close();
        } catch (SQLException ex) {
            throw new MyException("Error amb la desconnexió " + ex.getLocalizedMessage());
        }
    }

}
