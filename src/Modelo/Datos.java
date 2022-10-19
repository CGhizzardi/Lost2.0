package Modelo;

/** Clase que contiene todos las operaciones para el controlador */


public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;


    /** Metodo constructor de la clase Datos
     *
     * @param listaArticulos
     * @param listaClientes
     * @param listaPedidos
     */


    public Datos(ListaArticulos listaArticulos, ListaClientes listaClientes, ListaPedidos listaPedidos) {
        this.listaArticulos = listaArticulos;
        this.listaClientes = listaClientes;
        this.listaPedidos = listaPedidos;
    }
}
