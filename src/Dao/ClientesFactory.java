package Dao;

import Modelo.Articulos;
import Modelo.Clientes;
import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface ClientesFactory {
    public void insertarClientePremium(Clientes a);
    public void insertarClienteEstandar(Clientes a);

    public ClientesPremium convertirCPremium(ResultSet rs) throws SQLException;
    public ClientesEstandar convertirCStandar(ResultSet rs) throws SQLException;

    public void modificarCliente(Articulos a);

    public void eliminarCliente(String nif);

    public List<ClientesEstandar> obtenerClientesE();
    public List<ClientesPremium> obtenerClientesP();

    public ClientesPremium buscarClientePremium(String user, String pass, String codigo);
    public ClientesEstandar buscarClienteEstandar(String user, String pass,String codigo);
}
