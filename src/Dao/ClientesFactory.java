package Dao;

import Modelo.*;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;
public interface ClientesFactory {
    public void insertarCliente(Clientes a);

    public ClientesPremium convertirCPremium(ResultSet rs) throws SQLException;
    public ClientesEstandar convertirCStandar(ResultSet rs) throws SQLException;

    public void modificarCliente(Articulos a);

    public void eliminarCliente(Articulos a);

    public List<ClientesEstandar> obtenerClientesE();
    public List<ClientesPremium> obtenerClientesP();

    public ClientesPremium buscarClientePremium(String codigo);
    public ClientesEstandar buscarClienteEstandar(String codigo);
}
