package Controlador;
import Modelo.*;
import Vista.ArticuloVista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
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

    protected ControlArticulos artC = new ControlArticulos(art, artV);

    /** Metodo Constructor de la Clase
     *
     */


    public Controller() {

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


    public void addarticulo () {
        String codigos, descripciones;
        double precios, envios;
        int tiempos;



        System.out.println("introduce el codigo\n");
        codigos =input.nextLine();
        System.out.println("introduce la descripcion\n");
        descripciones =input.nextLine();
        System.out.println("introduce el precio, si tiene decimales separalos usando ( , )\n");
        precios =input.nextDouble();
        System.out.println("introduce el Costo de envio si tiene decimales separalos usando ( , )\n");
        envios =input.nextDouble();
        System.out.println("introduce el tiempo de envio\n");
        tiempos =input.nextInt();

        Articulos artic= new Articulos(codigos,descripciones, precios, envios,tiempos);


        datosPr.getListaArticulos().add(artic);
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

                }

        }    //bucle que recorre el array para comparar NIF e imprime el Cliente


    }

    //AGREGAR CLIENTE
    public void addCliente(){
        System.out.print("Introduce el NIF: ");
        String nif = input.nextLine();
        boolean existeClPr = existeClientePr(nif);
        boolean existeClEs = existeClienteEs(nif);
        if(existeClPr == true || existeClEs == true){
            System.out.println("\n\t¡Este cliente ya está registrado!");

        }else{

            System.out.print("Introduce el nombre del nuevo cliente: ");
            String nombre = input.nextLine();
            System.out.print("Indica domicilio: ");
            String addres = input.nextLine();
            System.out.print("Indica Email: ");
            String mail = input.nextLine();
            System.out.println("Elige el tipo de cliente: 1.Premium  2.Estandar");
            int option = input.nextInt();
            switch (option){
                case 1:
                    System.out.print("Indica cuota: ");
                    double cuota = input.nextDouble();
                    System.out.print("Indica descuento: ");
                    double descuento = input.nextDouble();

                    ClientesPremium c1 = new ClientesPremium(nombre, addres, nif, mail, cuota, descuento );
                    datosPr.getListaClientesPremium().add(c1);
                    input= new Scanner(System.in);
                    System.out.println("\nEl cliente se registro correctamente.\n");
                    break;
                case 2:
                    ClientesEstandar c2 = new ClientesEstandar(nombre, addres, nif, mail);
                    datosPr.getListaClientesEstandar().add(c2);
                    input= new Scanner(System.in);
                    System.out.println("\nEl cliente se registro correctamente.\n");
                    break;

                default:
                    System.out.print("Debes introducir un número: ");
            } input.reset();
        }input.reset();
    }

    //¿EXISTE CLIENTE PREMIUM?
    public boolean existeClientePr(String nif){
        String clNIF;
        ListaClientesPremium listaClPr = datosPr.getListaClientesPremium();
        for (int i = 0; i < listaClPr.getSize(); i++) {
            clNIF = listaClPr.getArt(i).getNif();
            if (nif.equals(clNIF)) {
                return true;
            }
        }
        return false;
    }

    //¿EXISTE CLIENTE ESTANDAR?
    public boolean existeClienteEs(String nif){
        ListaClientesEstandar listaClEs = datosPr.getListaClientesEstandar();
        String clNIF;
        for (int i = 0; i < listaClEs.getSize(); i++) {
            clNIF = listaClEs.getArt(i).getNif();
            if (nif.equals(clNIF)) {
                return true;
            }
        }
        return false;
    }

    //Mostrar Clientes Premium
    public void mostrarCliPr(){
        ListaClientesPremium premium = datosPr.getListaClientesPremium();
        int i = 0;
        System.out.println("=====Clientes Premium=====\n");
        for (i = 0; i < premium.getSize(); i++) {
            System.out.println(premium.getArt(i).getNif()+" "+ premium.getArt(i).getNombre() );
        }
    }

    //Mostrar Clientes Estandar
    public void mostrarCliEs(){
        ListaClientesEstandar estandar = datosPr.getListaClientesEstandar();
        int i = 0;
        System.out.println("=====Clients Estandar=====\n");
        for (i = 0; i < estandar.getSize(); i++) {
            System.out.println(estandar.getArt(i).getNif()+" "+ estandar.getArt(i).getNombre() );
        }

    }

    /** Pedidos */

    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = input.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }



    public void menuCrearPedido() {
        System.out.println("Añade el numero de pedido: ");

        Pedido pedido= new Pedido();
        int numeroPedido = input.nextInt();                     //numero pedido

        pedido.setNumeroPedido(numeroPedido);

        System.out.println("1. Escoge un cliente.\n" +
                "2. Crea un cliente.\n");

        int opcion = input.nextInt();
        Clientes clientePedido;
        if (opcion == 1) {
            System.out.println("=====================Listado de Clientes registrados========================\n");

            System.out.println("=====Clients Estandar=====");
            int i = 0;
            for (i = 0; i < datosPr.getListaClientesEstandar().getSize(); i++) {
                System.out.println(datosPr.getListaClientesEstandar().getArt(i).getNif() + " " + datosPr.getListaClientesEstandar().getArt(i).getNombre());
            }                               //bucle que imprime los nombres de los clientes
            System.out.println("............................................................................\n");
            System.out.println("=====Clientes Premium=====");
            for (i = 0; i < datosPr.getListaClientesPremium().getSize(); i++) {
                System.out.println(datosPr.getListaClientesPremium().getArt(i).getNif() + " " + datosPr.getListaClientesPremium().getArt(i).getNombre());
            }
            System.out.println("============================================================================\n");

            System.out.println("Introduce el NIF del cliente:\n ");
            Scanner input2 = new Scanner(System.in);
            String nif = input2.nextLine();
            //cliente registrado
            for (i = 0; i < datosPr.getListaClientesEstandar().getSize(); i++) {
                if(nif.equals(datosPr.getListaClientesEstandar().getArt(i).getNif())){
                    clientePedido = datosPr.getListaClientesEstandar().getArt(i);

                    pedido.setCliente(clientePedido);

                    System.out.println(" Cliente estandar registrado en el pedido.");
                }
            }
            for (i = 0; i < datosPr.getListaClientesPremium().getSize(); i++) {
                if(nif.equals(datosPr.getListaClientesPremium().getArt(i).getNif())){
                    clientePedido = datosPr.getListaClientesPremium().getArt(i);

                    pedido.setCliente(clientePedido);

                    System.out.println(" Cliente premium registrado en el pedido.");
                }
            }
        }else if(opcion==2){
            boolean salir = false;
            do {
                System.out.println("1. Crear Cliente Estandar");
                System.out.println("2. Crear Cliente Estandar");
                System.out.println("0. Salir");

                int opcio;
                System.out.println("Elige una opción (1,2 o 0):");
                opcio = input.nextInt();
                switch (opcio) {
                    case 1:
                        input.nextLine();
                        System.out.println("introduce el Nif");
                        String Nif= input.nextLine();
                        System.out.println("introduce el Nombre");
                        String name= input.nextLine();
                        System.out.println("introduce la Direccion");
                        String Addres= input.nextLine();
                        System.out.println("introduce un correo electronico");
                        String mail= input.nextLine();
                        ClientesEstandar cE= new ClientesEstandar(Nif, name, Addres, mail);
                        datosPr.getListaClientesEstandar().add(cE);
                        pedido.setCliente(cE);
                        System.out.println("Cliente standar añadido.");
                        salir=true;
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("introduce el Nif");

                        String nif= input.nextLine();
                        System.out.println("introduce el Nombre");
                        String Name= input.nextLine();
                        System.out.println("introduce la Direccion");
                        String dir= input.nextLine();
                        System.out.println("introduce un correo electronico");
                        String email= input.nextLine();
                        System.out.println("introduce la cuota mensual del socio");
                        double quotaCliente= input.nextDouble();
                        System.out.println("introduce el porcentage de descuento");
                        double porDes= input.nextDouble();
                        ClientesPremium cP= new ClientesPremium(nif, Name, dir, email, quotaCliente, porDes);
                        datosPr.getListaClientesPremium().add(cP);
                        pedido.setCliente(cP);
                        System.out.println("Cliente premium añadido.");
                        salir=true;
                        break;
                    case 0:
                        salir = true;
                }
            } while (!salir);
        }
        ListaArticulos listadoAr = datosPr.getListaArticulos();
        String codigoIngresado;
        String articuloCode;

        System.out.println("====================Listado de Articulos Disponibles======================");
        for (int i = 0; i < listadoAr.getSize(); i++) {
            System.out.println(listadoAr.getArt(i).getCodigo() + " " + listadoAr.getArt(i).getDescripcion());
        }                               //bucle que imprime los nombres de los articulos
        System.out.println("==========================================================================\n");

        System.out.println("Introduce el codigo del articulo para añadirlo al pedido: ");
        input.nextLine();                                                //para limpiar el buffer del "/n"
        String codigo = input.nextLine();

        for (int i = 0; i < datosPr.getListaArticulos().getSize(); i++) {
            if (codigo.equals(datosPr.getListaArticulos().getArt(i).getCodigo())) {
                Articulos articulo = datosPr.getListaArticulos().getArt(i);

                pedido.setArticulo(articulo);                                                     //articulo escogido

            }
        }

        System.out.println("Introduce la cantidad de articulos: ");
        int cantidadArticulos = input.nextInt();                                                //cantidad articulos

        pedido.setCantidadArticulos(cantidadArticulos);

        LocalDateTime horaActual= LocalDateTime.now();                                          //la hora del pedido
        pedido.setFechaHora(horaActual);


        datosPr.getListaPedidos().add(pedido);                                                  //pedido guardado en array



    }


    public void menuEliminarPedido(){
        System.out.println("MENU PARA ELIMINAR PEDIDOS\n");
        System.out.println("Introduce el numero del pedido.\n" +
                "(Recuerda que solo podras eliminar pedidos PENDIENTES DE ENVIO!)\n");
        int codigo=input.nextInt();
        for (int i = 0 ; i<datosPr.getListaPedidos().getSize();i++){
            if(codigo==datosPr.getListaPedidos().getArt(i).getNumeroPedido()){
                if( datosPr.getListaPedidos().getArt(i).getEnviado()){
                    System.out.println("Siento comunicarles que el pedido ya ha sido ENVIADO.");
                    break;
                }else{
                    datosPr.getListaPedidos().EliminarConArgumento(i);
                    System.out.println("El pedido "+codigo+" ha sido eliminado.");
                }
            }
        }
    }
    public void menuMostrarPendientesEnvio(){

        System.out.println("\nLista de los pedidos PENDIENTES de envio:\n");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < datosPr.getListaPedidos().getSize(); i++) {
            if (!datosPr.getListaPedidos().getArt(i).getEnviado()) {
                System.out.println(datosPr.getListaPedidos().getArt(i).toString());
            }
            System.out.println("-----------------------------------------------");
        }
    }
    public void menuMostrarEnviados(){
        System.out.println("\nLista de los pedidos ENVIADOS:\n");
        System.out.println("-----------------------------------------------");
        for (int i = 0 ; i<datosPr.getListaPedidos().getSize();i++){
            if (datosPr.getListaPedidos().getArt(i).getEnviado()) {
                System.out.println(datosPr.getListaPedidos().getArt(i).toString());
            }
            System.out.println("-----------------------------------------------");
        }
    }
    }





