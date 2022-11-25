package Dao;

import Modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PedidosFactory {
    public void insertarPedido(Pedido p);

    public Pedido convertirPedido(String user, String pass,ResultSet rs) throws SQLException;

    public void modificarPedido(Pedido p);

    public void eliminarPedido(String user, String pass,int numeroPedido);

    public Pedido obtenerPedido(String user, String pass,int codigo);

    public List<Pedido> obtenerPedidos(String user, String pass);

    public List<Pedido> obtenerEnviados(String user, String pass);
    public List<Pedido> obtenerNoEnviados(String user, String pass);
}
