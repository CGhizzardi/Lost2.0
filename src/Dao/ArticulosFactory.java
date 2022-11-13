package Dao;

import Modelo.*;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public interface ArticulosFactory {


    public void insertarArticulo(Articulos a);

    public Articulos convertir(ResultSet rs) throws SQLException;

    public void modificarArticulo(Articulos a);

    public void eliminarArticulo(String codigoArticulo);

    public List<Articulos> obtenerArticulos();

    public Articulos obtenerArticulo(String codigo);
}
