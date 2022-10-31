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

    /** Metodo que Muestra los Articulos
     *
     */

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

    /** Metodo que Muestra los Clientes
     *
     */

    public void mostrarCli(){

        ListaClientesEstandar listadoCE = datosPr.getListaClientesEstandar();
        ListaClientesPremium listadoPR = datosPr.getListaClientesPremium();
        String nifIngresado;
        String clienteNif;
        int i = 0;


        System.out.println("=====================Listado de Clientes registrados========================\n");

        System.out.println("=====Clients Estandar=====");
        for (i = 0; i < listadoCE.getSize(); i++) {
            System.out.println(listadoCE.getArt(i).getNif()+" "+ listadoCE.getArt(i).getNombre() );
        }                               //bucle que imprime los nombres de los clientes
        System.out.println("............................................................................\n");
        System.out.println("=====Clientes Premium=====");
        for (i = 0; i < listadoPR.getSize(); i++) {
            System.out.println(listadoPR.getArt(i).getNif()+" "+ listadoPR.getArt(i).getNombre() );
        }
        System.out.println("============================================================================\n");

        System.out.print("Introduce el NIF del Cliente que deseas mostrar:\n");
        nifIngresado = input.next();


        for (i = 0; i < listadoCE.getSize(); i++) {

            clienteNif = listadoCE.getArt(i).getNif();

            if (nifIngresado.equals(clienteNif)) {
                System.out.println("Cliente Estandar \n ");

                System.out.println("nif= " + listadoCE.getArt(i).getNif() + "\n" +
                        "nombre= " + listadoCE.getArt(i).getNombre() + "\n" +
                        "Domicilio= " + listadoCE.getArt(i).getDomicilio() + "\n" +
                        "e-Mail= " + listadoCE.getArt(i).getEmail() + "\n");
                break;

            } else {
                System.out.println("");
                break;
            }
        } //bucle que recorre el array para comparar NIF e imprime el Cliente

            for (i = 0; i < listadoPR.getSize(); i++) {

                clienteNif = listadoPR.getArt(i).getNif();

                if (nifIngresado.equals(clienteNif)) {
                    System.out.println("Cliente Premium \n ");

                    System.out.println("nif= " + listadoPR.getArt(i).getNif() + "\n" +
                            "nombre= " + listadoPR.getArt(i).getNombre() + "\n" +
                            "Domicilio =" + listadoPR.getArt(i).getDomicilio() + "\n" +
                            "e-Mail= " + listadoPR.getArt(i).getEmail() + "\n" +
                            "Cuota= " + listadoPR.getArt(i).getCuota() + "\n" +
                             "Descuento= " + listadoPR.getArt(i).getDescuento() + "\n");
                    break;

                } else {
                    System.out.println(" ");
                    break;
                }

        }    //bucle que recorre el array para comparar NIF e imprime el Cliente


    }


}
