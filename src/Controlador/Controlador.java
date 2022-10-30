package Controlador;
import Modelo.*;
import java.util.ArrayList;
public class Controlador {

    protected Datos datosPr;

    /** ArrayList para la creacion de los objetos de las clases
     * articulos, clientes y pedidos
     */

    public ArrayList<Articulos> listaArticulos;
    public ArrayList<ClientesEstandar> listaClientesEstandar;
    public ArrayList<ClientesPremium> listaClientesPremium;
    private ArrayList<Pedido> listaPedidos;

    /** Objetos de las clases Articulos, Clientes, Pedidos
     *
     */

    protected ListaArticulos articulosList= new ListaArticulos(listaArticulos);
    protected ListaClientesEstandar clientesEsList= new ListaClientesEstandar(listaClientesEstandar);
    protected ListaClientesPremium clientesPreList= new ListaClientesPremium(listaClientesPremium);
    protected ListaPedidos pedidosList= new ListaPedidos(listaPedidos);

    public Controlador() {

        this.datosPr=new Datos(articulosList ,clientesEsList, clientesPreList, pedidosList);
        this.datosPr.datosPrograma();
    }




    public Datos getDatosPr() {
        return datosPr;
    }

    public void setDatosPr(Datos datosPr) {
        this.datosPr = datosPr;
    }

    @Override
    public String toString() {
        return "Controlador{" +
                "datosPr=" + datosPr +
                '}';
    }
}