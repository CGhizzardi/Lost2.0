package Controlador;
import java.util.ArrayList;
import java.util.List;
import Modelo.*;


public class Controlador {

    /**Atributos de la Clase
     *
     */

    private Datos datos;

    /** ArrayList para la creacion de los objetos de las clases
     * articulos, clientes y pedidos
     */

    private ArrayList<Articulos> ListaArticulos;
    private ArrayList<Clientes> ListaClientes;
    private ArrayList<Pedidos> ListaPedidos;

    /** Objetos de las clases Articulos, Clientes, Pedidos
     *
     */

    protected ListaArticulos articulos= new ListaArticulos(ListaArticulos);
    protected ListaClientes clientes= new ListaClientes(ListaClientes);
    protected ListaPedidos pedidos= new ListaPedidos(ListaPedidos);



    public Controlador() {
        datos = new Datos (articulos,clientes,pedidos);
    }
// TO-BE-DONE
}
