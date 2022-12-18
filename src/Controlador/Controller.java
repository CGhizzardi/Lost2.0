package Controlador;

import Dao.*;
import Modelo.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    Scanner input = new Scanner(System.in);
    /**
     * ArrayList para la creacion de los objetos de las clases
     * articulos, clientes y pedidos
     */
    /*
    public ArrayList<Articulos> listaArticulos;
    protected ArrayList<ClientesEstandar> listaClientesEstandar;
    protected ArrayList<ClientesPremium> listaClientesPremium;
    private ArrayList<Pedido> listaPedidos;
    */

    /**
     * Objetos de las clases Articulos, Clientes, Pedidos
     */

    /*
    protected ListaArticulos articulosList = new ListaArticulos(listaArticulos);
    protected ListaClientesEstandar clientesEsList = new ListaClientesEstandar(listaClientesEstandar);
    protected ListaClientesPremium clientesPreList = new ListaClientesPremium(listaClientesPremium);
    protected ListaPedidos pedidosList = new ListaPedidos(listaPedidos);
    */

    String user;
    String pass;


    /** Metodo Constructor de la Clase
     *
     */


    public Controller() {
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

    /** Metodo que agrega los articulos a la Base de datos
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
    }*/


    public void OrmAddArticulo(String user, String pass){
        OrmArticulos articulo= new OrmArticulos(user, pass);
        Articulos articulos= articulo.crearArticulo();
        articulo.insArticulo(articulos);
    }


    /** Metodo que Muestra los Articulos METODO DEL PRODUCTO ANTERIOR
     *


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

        System.out.println(AD.obtenerArticulo(user,pass,codigoIngresado));

    } */

    public void ormMostarArticulo(String user, String pass){ /** Metodo que muestra loas articulos usando Hibernate */

        OrmArticulos articulos= new OrmArticulos(user,pass);

        articulos.ormImprimirArticulos();
    }


    /** Metodo que Muestra los Clientes METODO DEL PRODUCTO ANTERIOR


    public void mostrarCli(String user, String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        System.out.println("=====================Listado de Clientes registrados========================\n");

        System.out.println("=====Clients Estandar=====");
        System.out.println(CD.obtenerClientesE());

        System.out.println("............................................................................\n");
        System.out.println("=====Clientes Premium=====");
        System.out.println(CD.obtenerClientesP());
        System.out.println("============================================================================\n");

    } */

    public void ormMostarClientes(String user, String pass){ /** Metodo que muestra todos los clientes de ls BBDD con Hibernate */
        OrmCliente clientes= new OrmCliente(user,pass);
        clientes.ormImprimirClientes();
    }


    //AGREGAR CLIENTE METODO PRODUCTO ANTERIOR
    /**public void addCliente(String user, String pass){
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
                    float cuota = input.nextFloat();
                    System.out.print("Indica descuento: ");
                    float descuento = input.nextFloat();

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
    } */



    /** METODO QUE AGREGA UN CLIENTE USANDO HIBERNATE */
    public void ormAddClientes(String user, String pass){
        System.out.println("Que tipo de cliente deseas insertar?");
        OrmCliente cliente= new OrmCliente(user, pass);
        cliente.menuInsCliente(user, pass);

    }



/** Metodo que elimina clientes METODO DEL PRODUCTO ANTERIOR
    public void eliminarC(String user, String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        mostrarCli(user,pass);
        System.out.println("Instroduce el nif: ");
        String nif= input.nextLine();
        CD.eliminarCliente(nif);
        System.out.println("Cliente eliminado.");
    } */

public void ormDeleteCliente(String user, String pass){
    OrmCliente cliente= new OrmCliente(user, pass);

    cliente.ormImprimirClientes();
    cliente.ormMenuDeleteCliente();



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

    /**Mostrar Clientes Premium METODO DEL PRODUCTO ANTERIOR
    public void mostrarCliPr(String user,String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        System.out.println(CD.obtenerClientesP());
    }  */


    /** METODO QUE MUESTRA CLIENTES PREMIUM */

    public void ormShowClientesPre(String user, String pass){

        OrmCliente clientePremium= new OrmCliente(user, pass);
        System.out.println("Cargando clientes Premium");
        clientePremium.ormImprimirClientesPremium();
    }


    /**Mostrar Clientes Estandar METODO DEL PRODUCTO ANTERIOR
    public void mostrarCliEs(String user,String pass){
        ClientesDAO CD = new ClientesDAO(user,pass);
        System.out.println(CD.obtenerClientesE());

    } */


    public void ormShowClienteEstandar(){
        OrmCliente clienteEstandar= new OrmCliente(user, pass);
        System.out.println("Cargando clientes Estandar");
        clienteEstandar.ormImprimirClientesEstandar();
    }


    /**Metodo para crear Pediidos METODO DEL PRODUCTO ANTERIOR
    public void menuCrearPedido(String user, String pass) {

        ClientesDAO CD = new ClientesDAO(user, pass);
        ArticulosDAO AD = new ArticulosDAO(user,pass);
        PedidosDAO PD = new PedidosDAO(user,pass);
        Pedido pedido= new Pedido();

        //no hace falta ingresar el codigo del pedido, la BBDD lo calcula automaticamente.

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
            pedido.setCliente(CD.buscarClientePremium(user, pass,nif));     //cliente registrado(ESTA PUESTO SOLO PREMIUM PUEDE QUE NO FUNCIONE CON ESTANDAR)
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
                        float quotaCliente= input.nextFloat();
                        System.out.println("introduce el porcentage de descuento");
                        float porDes= input.nextFloat();
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

        System.out.println("====================Listado de Articulos Disponibles======================");

        System.out.println(AD.obtenerArticulos());

        System.out.println("==========================================================================\n");

        System.out.println("Introduce el codigo del articulo para añadirlo al pedido: ");
        input.nextLine();                                                //para limpiar el buffer del "/n"
        String codigo = input.nextLine();
        Articulos articulo = AD.obtenerArticulo(user, pass,codigo);
        pedido.setArticulo(articulo);                                                     //articulo escogido

        System.out.println("Introduce la cantidad de articulos: ");
        int cantidadArticulos = input.nextInt();                                                //cantidad articulos

        pedido.setCantidadArticulos(cantidadArticulos);

        LocalDateTime horaActual= LocalDateTime.now();                                          //la hora del pedido
        pedido.setFechaHora(horaActual);
        pedido.setPrecioTotal(pedido.getPrecioTotal());
        pedido.setEnviado(pedido.getEnviado());
        PD.insertarPedido(pedido);                                                 //pedido guardado en array
    } */


    public void ormCrearPedidos(){
        String nifCl;
        int idCl;
        int cantArticulo;
        double prTotal;
        double gastEnv;
        boolean env;
        float des;
        LocalDateTime fecha;
        Articulos genero;
        String codArticulo;
        Pedido pe;
        OrmPedidos pedido= new OrmPedidos();
        OrmArticulos articulo= new OrmArticulos(user,pass);
        OrmCliente cliente= new OrmCliente(user,pass);
        /** Obtencion del nif del cliente */
        nifCl=pedido.ormSeleccionarNifCliente(user, pass);
        System.out.println(nifCl);


        /** Obtencion del codigo del Articulos */
        genero= articulo.ormObtenerArticulo();
        codArticulo= genero.getCodigo();
        System.out.println(codArticulo);

        /** Obtencion de los gastos de envio */

        gastEnv= genero.getGastosDeEnvio();

        /** Obtencion de Descuento del cliente */
        cliente.ormImprimirClientes();
        System.out.println("Introduce nuevamente el id del cliente seleccionado");
        idCl= input.nextInt();
         des=pedido.ormObtenerDePrem(idCl);

        /** Obtencion de la cantidad de Articulos */
        System.out.println("introduce la cantidad de articulos del pedido");
        cantArticulo= input.nextInt();

        /** Creacion del pedido con metodo constructor */
        pe= new Pedido(nifCl,codArticulo,cantArticulo);

        /** Calculo del precio total del envio */
        prTotal=0;
        prTotal= (genero.getPrecioDeVenta()* cantArticulo) + ((1-(des / 100)) * gastEnv);
        pe.setPrecioTotal2(prTotal);
        fecha=LocalDateTime.now();
        pe.setFechaHora(fecha);
        env= false;

        pedido.insPedido(pe);


    }




    public void menuEliminarPedido(String user, String pass){
        System.out.println("MENU PARA ELIMINAR PEDIDOS\n");
        List<Pedido> pedidos = new ArrayList<Pedido>();
        PedidosDAO PD = new PedidosDAO(user,pass);
        pedidos= PD.obtenerPedidos(user, pass);

        for (int i=0; i<pedidos.size();i++){
            System.out.println("Numero de pedido: "+pedidos.get(i).getNumeroPedido()+
                    ", Articulo: "+pedidos.get(i).getArticulo().getCodigo()+" *"+pedidos.get(i).getCantidadArticulos()+
                    ", Fecha: "+pedidos.get(i).getFechaHora()+ ", Cliente: "+ pedidos.get(i).getCliente().getNif()+
                    "\nPRECIO TOTAL: "+pedidos.get(i).getPrecioTotal()+", ENVIADO: "+pedidos.get(i).getEnviado());
        }
        System.out.println("Introduce el numero del pedido.\n" +
                "(Recuerda que solo podras eliminar pedidos PENDIENTES DE ENVIO!)\n");

        int codigo=input.nextInt();

        for (int i = 0 ; i<pedidos.size();i++){
            if(codigo==pedidos.get(i).getNumeroPedido()){
                if(!pedidos.get(i).getEnviado()){
                    PD.eliminarPedido(user,pass,pedidos.get(i).getNumeroPedido());
                    System.out.println("El pedido "+pedidos.get(i).getNumeroPedido()+" ha sido eliminado.");
                }else{
                    System.out.println("Siento comunicarles que el pedido ya ha sido ENVIADO.");
                }
            }
        }
    }
    public void menuMostrarPendientesEnvio(String user, String pass){
        PedidosDAO PD = new PedidosDAO(user, pass);
        System.out.println("\nLista de los pedidos PENDIENTES de envio:\n");
        System.out.println("-----------------------------------------------");
        System.out.println(PD.obtenerNoEnviados(user, pass));
        if (PD.obtenerNoEnviados(user, pass)==null){
            System.out.println("No hay pedidos pendientes de envio");
        }
    }
    public void menuMostrarEnviados(String user, String pass){
        PedidosDAO PD = new PedidosDAO(user, pass);
        System.out.println("\nLista de los pedidos ENVIADOS:\n");
        System.out.println("-----------------------------------------------");
        System.out.println(PD.obtenerEnviados(user, pass));
    }
    public void menuMostrarPedido(String user, String pass){
        PedidosDAO PD = new PedidosDAO(user, pass);
        System.out.println("Introduce el codigo del pedido: ");
        int codigo= input.nextInt();
        System.out.println(PD.obtenerPedido(user, pass,codigo));
    }
    public void menuMostrarPedidos(String user, String pass){
        PedidosDAO PD = new PedidosDAO(user, pass);
        System.out.println("\nLista de los pedidos:");
        System.out.println("-----------------------------------------------");
        System.out.println(PD.obtenerPedidos(user, pass));
        System.out.println("-----------------------------------------------");
    }
}