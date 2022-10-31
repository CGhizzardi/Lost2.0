package Controlador;
import Modelo.*;
import Vista.ArticuloVista;
import java.util.ArrayList;
import java.util.Scanner;

public class controller {
    Scanner input = new Scanner(System.in);
    protected Datos datosPr;

    /**
     * ArrayList para la creacion de los objetos de las clases
     * articulos, clientes y pedidos
     */

    public ArrayList<Articulos> listaArticulos;
    protected ArrayList<ClientesEstandar> listaClientesEstandar;
    protected ArrayList<ClientesPremium> listaClientesPremium;
    private ArrayList<Pedido> listaPedidos;

    /**
     * Objetos de las clases Articulos, Clientes, Pedidos
     */

    protected ListaArticulos articulosList = new ListaArticulos(listaArticulos);
    protected ListaClientesEstandar clientesEsList = new ListaClientesEstandar(listaClientesEstandar);
    protected ListaClientesPremium clientesPreList = new ListaClientesPremium(listaClientesPremium);
    protected ListaPedidos pedidosList = new ListaPedidos(listaPedidos);

    protected ArticuloVista artV;

    protected Articulos art;

    protected controlArticulos artC = new controlArticulos(art, artV);

    public controller() {

        this.datosPr = new Datos(articulosList, clientesEsList, clientesPreList, pedidosList);
        this.datosPr.datosPrograma();
    }


    /**
     * metodos Getters y Setters
     *
     * @return
     */

    public Datos getDatosPr() {
        return datosPr;
    }

    public void setDatosPr(Datos datosPr) {
        this.datosPr = datosPr;
    }

    /**
     * Metodo que devuelve la lista de los articulos
     *
     * @return
     */

    public ListaArticulos getArticulosList() {
        return datosPr.getListaArticulos();
    }

    /**
     * Metodo que devuelve la lista de los Clientes Premium
     *
     * @return
     */

    public ListaClientesPremium getClientesPreList() {
        return datosPr.getListaClientesPremium();
    }

    /**
     * Metodo que devuelve la lista de los Clientes Estandar
     *
     * @return
     */

    public ListaClientesEstandar getClientesEsList() {
        return datosPr.getListaClientesEstandar();

    }

    public void MostrarArticulo() {


        ListaArticulos listadoAr = datosPr.getListaArticulos();
        String codigoIngresado;
        String articuloCode;
        int i = 0;


        System.out.println("====================Listado de Articulos Disponibles======================");
        for (i = 0; i < listadoAr.getSize(); i++) {
            System.out.println(listadoAr.getArt(i).getCodigo()+" "+ listadoAr.getArt(i).getDescripcion() );
        }                               //bucle que imprime los nombres de los articulos
        System.out.println("==========================================================================\n");

        System.out.print("Introduce el codigo del articulo que deseas mostrar:\n");
        codigoIngresado = input.next();

        for (i = 0; i < listadoAr.getSize(); i++) {

            articuloCode = listadoAr.getArt(i).getCodigo();

            if (codigoIngresado.equals(articuloCode)) {

                System.out.println("articulos codigo=" + listadoAr.getArt(i).getCodigo() + "\n" +
                        "descripcion=" + listadoAr.getArt(i).getDescripcion() + "\n" +
                        "precioDeVenta=" + listadoAr.getArt(i).getPrecioDeVenta() + "\n" +
                        "gastosDeEnvio=" + listadoAr.getArt(i).getGastosDeEnvio() + "\n" +
                        "tiempoDePreparacion=" + listadoAr.getArt(i).getTiempoDePreparacion() + "\n");
break;

            } else {
                System.out.println("El codigo seleccionado no existe \n ");
break;
            }


        }    //bucle que recorre el array para comparar nombres e imprime el articulo

    }
}
