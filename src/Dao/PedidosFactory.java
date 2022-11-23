package Dao;

import Modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PedidosFactory {
    public void insertarPedido(Pedido p);

    public Pedido convertirPedido(ResultSet rs) throws SQLException;

    public void modificarPedido(Pedido p);

    public void eliminarPedido(int numeroPedido);

    public Pedido obtenerPedido(int codigo);

    public List<Pedido> obtenerPedidos();

    public List<Pedido> obtenerEnviados();
    public List<Pedido> obtenerNoEnviados();
}
