package Dao;

import Modelo.*;
import Modelo.Pedido;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import  java.text.DateFormat;
import java.time.ZoneId;


public class PedidosDAO implements PedidosFactory{

    Entidad e = new Entidad();
    final String INSERT = "INSERT INTO pedidos VALUES(0,?,?,?,?,?)";
    final String UPDATE = "";
    final String DELETE = "DELETE FROM lost.pedidos WHERE numeroPedido = ?;";
    final String GETALL = "SELECT * FROM pedidos";
    final String GETONE = "SELECT * FROM pedidos WHERE numeroPedido = ?";

    final String GET_ENVIADOS = "SELECT * FROM pedidos WHERE enviado != 0";
    final String GET_NO_ENVIADOS = "SELECT * FROM pedidos WHERE enviado = 0";
    private Connection conn;
    String user;
    String pass;
    ClientesDAO CD = new ClientesDAO(user, pass);
    ArticulosDAO AD = new ArticulosDAO(user, pass);
    public PedidosDAO(String user, String pass) {

        this.user = user;
        this.pass = pass;
    }

    @Override
    public void insertarPedido(Pedido p){
        PreparedStatement stat = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);
            stat = conn.prepareStatement(INSERT);
            //stat.setInt(1, p.getNumeroPedido());
            stat.setString(1, p.getCliente().getNif());
            stat.setString(2, p.getArticulo().getCodigo());
            stat.setInt(3, p.getCantidadArticulos());
            stat.setDouble(4, p.getPrecioTotal());
            stat.setObject(5, p.getFechaHora());
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
    public Pedido convertirPedido(String user, String pass,ResultSet rs) throws SQLException{
        Articulos articulos;
        Clientes cliente;
        Pedido p = new Pedido();

        int numeroPedido = rs.getInt("numeroPedido");
        String nifCliente = rs.getString("nifCliente");
        cliente = CD.buscarClientePremium(user,pass,nifCliente);
        if (cliente == null) { cliente = CD.buscarClienteEstandar(user, pass,nifCliente); }
        String codigoArticulo = rs.getString("articulo");
        articulos = AD.obtenerArticulo(user,pass,codigoArticulo);
        int cantidadArticulos = rs.getInt("cantidadArticulos");
        Date fechaDate = rs.getTimestamp("fechaHora");
        //formula para convertir DATE a LOCALDATETIME
        LocalDateTime fecha = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        double precioTotal = rs.getDouble("precioTotal");
        p.setNumeroPedido(numeroPedido);
        p.setCliente(cliente);
        p.setArticulo(articulos);
        p.setCantidadArticulos(cantidadArticulos);
        p.setFechaHora(fecha);
        p.setPrecioTotal(p.getPrecioTotal());
        p.setEnviado(p.pedidoEnviado(fecha,articulos.getTiempoDePreparacion()));

        return p;
    }
    @Override
    public void modificarPedido(Pedido p){

    }
    @Override
    public void eliminarPedido(String user, String pass,int numeroPedido){
        PreparedStatement s = null;
        try{

            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(DELETE);

            s.setInt(1, numeroPedido);
            s.execute();
        }catch(Exception e){
            System.out.println("Algo no ha ido bien eliminando el pedido");
            System.out.println(e);
        }
    }
    @Override
    public Pedido obtenerPedido (String user, String pass,int codigo){    //devuelve un pedido

        PreparedStatement s = null;
        ResultSet rs = null;
        Pedido p = null;
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETONE);
            s.setInt(1, codigo);
            rs = s.executeQuery();
            if (rs.next()) {
                p = convertirPedido(user,pass,rs);
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
        return p;
    }
    @Override
    public List<Pedido>  obtenerPedidos(String user, String pass){   //devuelve una lista con los pedidos
        PreparedStatement s = null;
        ResultSet rs = null;
        List<Pedido> p = new ArrayList<>();
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETALL);
            rs = s.executeQuery();
            while (rs.next()) {
                p.add(convertirPedido(user,pass,rs));
            }
        } catch (SQLException ex){
            System.out.println("Error en Sql");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error cerrando Resultset en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error cerrando Statement en SQL");
                }
            }
        }
        return p;
    }
    @Override
    public List<Pedido> obtenerEnviados(String user, String pass){
        PreparedStatement s = null;

        ResultSet rs = null;
        List<Pedido> p = new ArrayList<>();
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETALL);
            rs = s.executeQuery();
            while (rs.next()) {
                Pedido pedido;
                pedido= convertirPedido(user,pass,rs);
                boolean enviado = pedido.pedidoEnviado(pedido.getFechaHora(), pedido.getArticulo().getTiempoDePreparacion());
                if(enviado){
                    p.add(convertirPedido(user,pass,rs));
                }
            }
        } catch (SQLException ex){
            System.out.println("Error en Sql");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error cerrando Resultset en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error cerrando Statement en SQL");
                }
            }
        }
        return p;
    }
    @Override
    public List<Pedido> obtenerNoEnviados(String user, String pass){
        PreparedStatement s = null;

        ResultSet rs = null;
        List<Pedido> p = new ArrayList<>();
        try {
            Connection conn = e.conectarBBDD(user,pass);
            s = conn.prepareStatement(GETALL);
            rs = s.executeQuery();
            while (rs.next()) {
                Pedido pedido;
                pedido= convertirPedido(user,pass,rs);
                boolean enviado = pedido.pedidoEnviado(pedido.getFechaHora(), pedido.getArticulo().getTiempoDePreparacion());
                if(!enviado){
                    p.add(convertirPedido(user,pass,rs));
                }
            }
        } catch (SQLException ex){
            System.out.println("Error en Sql");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error cerrando Resultset en SQL");
                }
            }
            if(s != null ){
                try{
                    s.close();
                }catch (Exception e){
                    System.out.println("Error cerrando Statement en SQL");
                }
            }
        }
        return p;
    }
}