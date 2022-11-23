package Controlador;
import Modelo.*;
import Vista.ArticuloVista;
import Dao.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    String user;
    String pass;
    ClientesDAO CD = new ClientesDAO(user, pass);
    ArticulosDAO AD = new ArticulosDAO(user,pass);
    PedidosDAO PD = new PedidosDAO(user,pass);


    /** Metodo Constructor de la Clase
     *
     */


    public Controller() {

        this.datosPr = new Datos(articulosList, clientesEsList, clientesPreList, pedidosList);
        this.datosPr.datosPrograma();
    }


    public ListaClientesPremium getClientesPreList() {
        return datosPr.getListaClientesPremium();
    }




    public String USUARIO(){
        System.out.println("Instroduce el usuario para la BBDD: ");
        String user=input.nextLine();
        return user;
    }
    public String PASSWORD(){
        System.out.println("Instroduce el password para la BBDD: ");
        String pass=input.nextLine();
        return pass;

    }

    /** Metodo que agrega los articulos a la Base de datos */
    public void addarticulo (String user, String pass) {
        ArticulosDAO AD = new ArticulosDAO(user, pass);
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

        AD.insertarArticulo(artic);
        //datosPr.getListaArticulos().add(artic);
    }


        /** Metodo que Muestra los Articulos
         *
         */

    public void MostrarArticulo(String user, String pass) {

        ArticulosDAO AD = new ArticulosDAO(user, pass);

        //ListaArticulos listadoAr = datosPr.getListaArticulos();
        String codigoIngresado;
        String articuloCode;
        int i = 0;


        System.out.println("====================Listado de Articulos Disponibles======================");

        System.out.println(AD.obtenerArticulos());
        System.out.println("==========================================================================\n");

        System.out.print("Introduce el codigo del articulo que deseas mostrar:\n");
        codigoIngresado = input.next();

        System.out.println(AD.obtenerArticulo(codigoIngresado));

    }

    /** Metodo que Muestra los Clientes
     *
     */

    public void mostrarCli(String user, String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        /*ListaClientesEstandar listadoCE = datosPr.getListaClientesEstandar();
        ListaClientesPremium listadoPR = datosPr.getListaClientesPremium();*/
        String nifIngresado;
        String clienteNif;
        int i = 0;


        System.out.println("=====================Listado de Clientes registrados========================\n");

        System.out.println("=====Clients Estandar=====");
        System.out.println(CD.obtenerClientesE());

        System.out.println("............................................................................\n");
        System.out.println("=====Clientes Premium=====");
        System.out.println(CD.obtenerClientesP());
        System.out.println("============================================================================\n");

        /*System.out.print("Introduce el NIF del Cliente que deseas mostrar:\n");
        nifIngresado = input.next();
        CD.buscarClienteEstandar(nifIngresado);
        CD.buscarClientePremium(nifIngresado);
        */


    }

    //AGREGAR CLIENTE
    public void addCliente(String user, String pass){
        ClientesDAO CD= new ClientesDAO(user,pass);
        System.out.print("Introduce el NIF: ");
        String nif = input.nextLine();
        boolean existeClPr = existeClientePr(user, pass,nif);
        boolean existeClEs = existeClienteEs(user, pass,nif);
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
                    CD.insertarClientePremium(c1);
                    input= new Scanner(System.in);
                    System.out.println("\nEl cliente se registro correctamente.\n");
                    break;
                case 2:
                    ClientesEstandar c2 = new ClientesEstandar(nombre, addres, nif, mail);
                    CD.insertarClienteEstandar(c2);
                    input= new Scanner(System.in);
                    System.out.println("\nEl cliente se registro correctamente.\n");
                    break;

                default:
                    System.out.print("Debes introducir un número: ");
            } input.reset();
        }input.reset();
    }
    public void eliminarC(String user, String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        mostrarCli(user,pass);
        System.out.println("Instroduce el nif: ");
        String nif= input.nextLine();
        CD.eliminarCliente(nif);
        System.out.println("Cliente eliminado.");
    }

    public boolean existeClientePr(String user, String pass,String nif){
        String clNIF;
        ClientesDAO CD = new ClientesDAO(user,pass);

        List<ClientesPremium> clientesPremium = CD.obtenerClientesP();

        for (int i = 0; i < clientesPremium.size(); i++) {
            clNIF = clientesPremium.get(i).getNif();
            if (nif.equals(clNIF)) {
                return true;
            }
        }
        return false;
    }

    //¿EXISTE CLIENTE ESTANDAR?
    public boolean existeClienteEs(String user, String pass,String nif){
        String clNIF;
        ClientesDAO CD = new ClientesDAO(user,pass);

        List<ClientesEstandar> clientesEstandar = CD.obtenerClientesE();

        for (int i = 0; i < clientesEstandar.size(); i++) {
            clNIF = clientesEstandar.get(i).getNif();
            if (nif.equals(clNIF)) {
                return true;
            }
        }
        return false;
    }

    //Mostrar Clientes Premium
    public void mostrarCliPr(String user,String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        System.out.println(CD.obtenerClientesP());
    }

    //Mostrar Clientes Estandar
    public void mostrarCliEs(String user,String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        System.out.println(CD.obtenerClientesE());

    }



    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = input.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }



    public void menuCrearPedido(String user, String pass) {

        ClientesDAO CD = new ClientesDAO(user, pass);
        ArticulosDAO AD = new ArticulosDAO(user,pass);
        PedidosDAO PD = new PedidosDAO(user,pass);
        Pedido pedido= new Pedido();


        System.out.println("Añade el numero de pedido: ");
        int numeroPedido = input.nextInt();                         //numero de pedido
        pedido.setNumeroPedido(numeroPedido);

        System.out.println("1. Escoge un cliente.\n" +
                "2. Crea un cliente.\n");

        int opcion = input.nextInt();

        if (opcion == 1) {
            System.out.println("=====================Listado de Clientes registrados========================\n");

            System.out.println("=====Clients Estandar=====");
            System.out.println(CD.obtenerClientesE());
            System.out.println("............................................................................\n");
            System.out.println("=====Clientes Premium=====");
            System.out.println(CD.obtenerClientesP());
            System.out.println("============================================================================\n");

            System.out.println("Introduce el NIF del cliente:\n ");
            Scanner input2 = new Scanner(System.in);
            String nif = input2.nextLine();


            pedido.setCliente(CD.buscarClientePremium(nif));     //cliente registrado(ESTA PUESTO SOLO PREMIUM PUEDE QUE NO FUNCIONE CON ESTANDAR)


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
                        CD.insertarClienteEstandar(cE);
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
                        CD.insertarClienteEstandar(cP);
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

        System.out.println(AD.obtenerArticulos());

        System.out.println("==========================================================================\n");

        System.out.println("Introduce el codigo del articulo para añadirlo al pedido: ");
        input.nextLine();                                                //para limpiar el buffer del "/n"
        String codigo = input.nextLine();
        Articulos articulo = AD.obtenerArticulo(codigo);
        pedido.setArticulo(articulo);                                                     //articulo escogido

        System.out.println("Introduce la cantidad de articulos: ");
        int cantidadArticulos = input.nextInt();                                                //cantidad articulos

        pedido.setCantidadArticulos(cantidadArticulos);

        LocalDateTime horaActual= LocalDateTime.now();                                          //la hora del pedido
        pedido.setFechaHora(horaActual);
        pedido.setPrecioTotal(pedido.getPrecioTotal());
        pedido.setEnviado(pedido.getEnviado());
        PD.insertarPedido(pedido);                                                 //pedido guardado en array
    }


    public void menuEliminarPedido(String user, String pass){
        List<Pedido> pedidos = new ArrayList<Pedido>();
        System.out.println("MENU PARA ELIMINAR PEDIDOS\n");
        System.out.println("Introduce el numero del pedido.\n" +
                "(Recuerda que solo podras eliminar pedidos PENDIENTES DE ENVIO!)\n");
        int codigo=input.nextInt();
        PedidosDAO PD = new PedidosDAO(user,pass);
        pedidos= PD.obtenerPedidos();
        for (int i = 0 ; i<pedidos.size();i++){
            if(codigo==pedidos.get(i).getNumeroPedido()){
                if( pedidos.get(i).getEnviado()){
                    System.out.println("Siento comunicarles que el pedido ya ha sido ENVIADO.");
                    break;
                }else{
                    int nPedido= pedidos.get(i).getNumeroPedido();
                    PD.eliminarPedido(nPedido);
                    System.out.println("El pedido "+codigo+" ha sido eliminado.");
                }
            }
        }
    }
    public void menuMostrarPendientesEnvio(){

        System.out.println("\nLista de los pedidos PENDIENTES de envio:\n");
        System.out.println("-----------------------------------------------");
        System.out.println(PD.obtenerNoEnviados());
    }
    public void menuMostrarEnviados(){
        System.out.println("\nLista de los pedidos ENVIADOS:\n");
        System.out.println("-----------------------------------------------");
        System.out.println(PD.obtenerEnviados());
    }
    public void menuMostrarPedido(){
        System.out.println("Introduce el codigo del pedido: ");
        int codigo= input.nextInt();
        System.out.println(PD.obtenerPedido(codigo));
    }
    }





