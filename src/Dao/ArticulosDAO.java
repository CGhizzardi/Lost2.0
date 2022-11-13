package Dao;

import Modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDAO implements ArticulosFactory {
    Entidad e = new Entidad();
    final String INSERT = "INSERT INTO articulos VALUES(?,?,?,?,?)";
    final String UPDATE = "";
    final String DELETE = "DELETE FROM articulos WHERE codigoArticulo = ?";
    final String GETALL = "SELECT * FROM articulos";
    final String GETONE = "SELECT * FROM articulos WHERE codigoArticulo = ?";
    private Connection conn;

    public ArticulosDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertarArticulo(Articulos a) { // inserta articulo a la BBDD
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getCodigo());
            stat.setString(2, a.getDescripcion());
            stat.setDouble(3, a.getPrecioDeVenta());
            stat.setDouble(4, a.getGastosDeEnvio());
            stat.setLong(5, a.getTiempoDePreparacion()); //en articulos esta como INT i en la BBDD igual, pero me da error:
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
    public  Articulos convertir(ResultSet rs) throws SQLException {
        String codigo = rs.getString("codigoArticulo");
        String descripcion = rs.getString("descripcion");
        double precioVenta = rs.getDouble("precioVenta");
        double gastosEnvio = rs.getDouble("gastosEnvio");
        int tiempoPreparacion = rs.getInt("tiempoPreparacion");
        Articulos a = new Articulos(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        return a;
    }
    @Override
    public void modificarArticulo(Articulos a) {

    }
    @Override
    public void eliminarArticulo(String codigoArticulo) {                   //borrar articulo insertando el codigo dle articulo
        PreparedStatement s = null;
        try{
            s = conn.prepareStatement(DELETE);
            s.setString(1, codigoArticulo);
            s.executeUpdate();
            System.out.println("Articulo eliminado.\n");
        }catch(Exception e){
            System.out.println("Algo no ha ido bien");
        }

    }
    @Override
    public List<Articulos> obtenerArticulos() {
        PreparedStatement s = null;
        ResultSet rs = null;
        List<Articulos> articulos = new ArrayList<>();
        Articulos a = null;
        try {
            s = conn.prepareStatement(GETALL);
            rs = s.executeQuery();
            while (rs.next()) {
                articulos.add(convertir(rs));
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
        return articulos;
    }
    @Override
    public Articulos obtenerArticulo(String codigo) {
        PreparedStatement s = null;
        ResultSet rs = null;
        Articulos a = null;
        try {
            s = conn.prepareStatement(GETONE);
            s.setString(1, codigo);
            rs = s.executeQuery();
            if (rs.next()) {
                a = convertir(rs);
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
