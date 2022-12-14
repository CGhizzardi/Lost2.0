package Dao;

import Modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class ClientesDAO implements ClientesFactory{
    final String INSERT_PREMIUM = "INSERT INTO clientes VALUES(?,?,?,?,?,?)";
    final String INSERT_ESTANDAR = "INSERT INTO clientes VALUES(?,?,?,?,null, null)";
    final String UPDATE = "";
    final String DELETE = "DELETE FROM clientes WHERE nif = ?";
    final String GETALL_Premium = "SELECT * FROM clientes where cuotaMensual is not null";
    final String GETALL_Estandar = "SELECT * FROM clientes where cuotaMensual is null";
    final String GETONE = "SELECT * FROM clientes WHERE nif = ?";
    Entidad e = new Entidad();
    String user;
    String pass;


    public ClientesDAO(String user, String pass) {
        this.user=user;
        this.pass=pass;
    }
    @Override
    public void insertarClientePremium(Clientes a) { // inserta CLIENTE a la BBDD      (sin distinguir clientes premium de estandar!)
        PreparedStatement stat = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);
            stat = conn.prepareStatement(INSERT_PREMIUM);
            stat.setString(1, a.getNif());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getDomicilio());
            stat.setString(4, a.getEmail());
            //stat.setFloat(5, a.calcAnual());                //  ATENTO AQUI POSIBLE ERROR
            stat.setDouble(6, a.getDescuento());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("No ha funcionado.");
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println("ERROR");

                }
            }
        }
    }
    @Override
    public void insertarClienteEstandar(Clientes a) { // inserta CLIENTE a la BBDD      (sin distinguir clientes premium de estandar!)
        PreparedStatement stat = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);
            stat = conn.prepareStatement(INSERT_ESTANDAR);
            stat.setString(1, a.getNif());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getDomicilio());
            stat.setString(4, a.getEmail());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("No ha funcionado.");
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println("ERROR");

                }
            }
        }
    }
    @Override
    public ClientesPremium convertirCPremium(ResultSet rs) throws SQLException {
        String nif = rs.getString("nif");
        String nombre = rs.getString("nombre");
        String domicilio = rs.getString("domicilio");
        String email = rs.getString("email");
        float cuotaMensual = rs.getInt("cuotaMensual");
        float descuento = rs.getFloat("descuento");

        ClientesPremium a = new ClientesPremium(nombre,domicilio,nif,email,cuotaMensual,descuento);
        return a;
    }
    @Override
    public ClientesEstandar convertirCStandar(ResultSet rs) throws SQLException {
        String nif = rs.getString("nif");
        String nombre = rs.getString("nombre");
        String domicilio = rs.getString("domicilio");
        String email = rs.getString("email");

        ClientesEstandar a = new ClientesEstandar(nombre,domicilio,nif,email);
        return a;
    }
    @Override
    public void modificarCliente(Articulos a) {

    }
    @Override
    public void eliminarCliente(String nif) {
        PreparedStatement stat = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);

            stat = conn.prepareStatement(DELETE);
            stat.setString(1, nif);

            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("No ha funcionado.");
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println("ERROR");

                }
            }
        }
    }
    @Override
    public List<ClientesEstandar> obtenerClientesE() {         //funcion para listar todos los clientes ESTANDAR
        PreparedStatement s = null;
        ResultSet rs = null;
        List<ClientesEstandar> clientesEstandar = new ArrayList<>();
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETALL_Estandar);
            rs = s.executeQuery();
            while (rs.next()) {
                clientesEstandar.add(convertirCStandar(rs));
            }
        } catch (SQLException ex){
            System.out.println("Error en SQL");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error en SQL");
                }
            }
        }
        return clientesEstandar;
    }

    @Override
    public List<ClientesPremium> obtenerClientesP() {         //funcion para listar todos los clientes Premium
        PreparedStatement s = null;
        ResultSet rs = null;
        List<ClientesPremium> clientesPremium = new ArrayList<>();

        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETALL_Premium);
            rs = s.executeQuery();
            while (rs.next()) {
                clientesPremium.add(convertirCPremium(rs));
            }
        } catch (SQLException ex){
            System.out.println("Error en SQL");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error en SQL");
                }
            }
        }
        return clientesPremium;
    }


    @Override
    public ClientesPremium buscarClientePremium(String user, String pass,String codigo) {
        PreparedStatement s = null;
        ResultSet rs = null;
        ClientesPremium a = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETONE);
            s.setString(1, codigo);
            rs = s.executeQuery();
            if (rs.next()) {
                a = convertirCPremium(rs);
            } else {
                System.out.println("No se ha encontrado el registro");
            }
        } catch (SQLException ex){
            System.out.println("Error en SQL");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error en SQL");
                }
            }
        }
        return a;
    }

    @Override
    public ClientesEstandar buscarClienteEstandar(String user, String pass,String codigo) {
        PreparedStatement s = null;
        ResultSet rs = null;
        ClientesEstandar a = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETONE);
            s.setString(1, codigo);
            rs = s.executeQuery();
            if (rs.next()) {
                a = convertirCStandar(rs);
            } else {
                System.out.println("No se ha encontrado el registro");
            }
        } catch (SQLException ex){
            System.out.println("Error en SQL");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error en SQL");
                }
            }
        }
        return a;
    }
}
