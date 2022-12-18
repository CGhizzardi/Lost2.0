package Dao;


import Controlador.Controller;
import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;
import Modelo.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class OrmPedidos {

    Scanner input = new Scanner(System.in);

    public OrmPedidos() {
    }

    public void ormAgregarPedido() {

        System.out.println("Por favor seleccione un cliente o  agregue uno");


    }

    public String ormSeleccionarNifCliente(String user, String pass) { /** Metodo que devuelve el nif del cliente */
        boolean salir = false;
        char opcio;
        char opcion;


        Controller c = new Controller();
        ClientesEstandar est;
        ClientesPremium premium;
        OrmCliente cliente = new OrmCliente(user, pass);

        String nif = null;
        System.out.println("Hay que ingresar un cliente, que desea hacer?");
        do {
            System.out.println("1. Crear un Cliente");
            System.out.println("2. Seleccionar un Cliente Existente");

            opcio = pedirOpcion();
            switch (opcio) {
                case '1':   /** Opcion de crear un cliente */
                    nif = cliente.crearClientePedido(user, pass);
                    salir = true;
                    break;
                case '2':  /** Opcion de seleccionar un cliente en lugar de crearlo */
                    //c.ormMostarClientes(user, pass);
                    do {
                        System.out.println("A que tipo de cliente desea facturar?");
                        System.out.println("1. Elegir Clientes Estandar");
                        System.out.println("2. Elegir Clientes Premium");
                        opcion = pedirOpcion();
                        switch (opcion) {
                            case '1':
                                int id= cliente.ormIntroduceIdClienteEstandar(user, pass);
                                ClientesEstandar ces = cliente.ormObtenerCE(user, pass,id);
                                nif = cliente.nifClienteES(ces);
                                salir = true;
                                break;
                            case '2':
                                int id1= cliente.ormIntroduceIdClientePremium(user, pass);
                                ClientesPremium cpr = cliente.ormObtenerPR(user, pass, id1);
                                nif = cliente.nifClientePR(cpr);
                                salir = true;
                                break;

                        }
                    } while (!salir);
            }
        } while (!salir);
        return nif;
    }


    public char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2 o 0):");
        resp = input.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }


    public float ormObtenerDePedidos(int id) { /** Metodo para Obtener el descuento */
        float descuento = 0;
        char opcio;
        ClientesPremium cli;
        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSession = ormSessions.openSession();

        System.out.println("Selecciona el tipo de cliente para fijar obtener el descuento\n");
        System.out.println("1. Cliente estandar");
        System.out.println("2. Cliente premium");

        opcio = pedirOpcion();
        switch (opcio) {
            case '1':
                descuento = 0;
                break;
            case '2':
                descuento = 0;

                try {
                    actualSession.beginTransaction();
                    cli = actualSession.get(ClientesPremium.class, id);
                    descuento = cli.getDescuento();
                    actualSession.getTransaction().commit();
                    return descuento;
                } finally {
                    actualSession.close();
                }
        }
        return descuento;
    }

    public void insPedido(Pedido ped){ /**Metodo usado para insertar el objeto de tipo pedido en la BBDD con ORM */

        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pedido.class).buildSessionFactory();
        Session actualSession = ormSessions.openSession();

        try {

            actualSession.beginTransaction();
            actualSession.save(ped);
            actualSession.getTransaction().commit();
            ;
            System.out.println("Pedido guardado exitosamente");
        }catch(Exception e){

            System.out.println("Error al guardar el Pedido");

        } finally {
            actualSession.close();
        }
    }

    public void ormBorrarPedidos() {   /** Metodo que borra un pedido */

        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pedido.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();
        int idPedido;



        System.out.println("Introduce el id del Pedido que deseas eliminar\n");
        idPedido = input.nextInt();
        System.out.println(" ");

        try {
            actualSessions.beginTransaction();
            ClientesPremium cpr = actualSessions.get(ClientesPremium.class, idPedido);
            actualSessions.delete(cpr);
            actualSessions.getTransaction().commit();
            System.out.println("registro eliminado.");

        } finally {
            actualSessions.close();
        }
    }






    public void ormImprimirPedidos() {  /** Imprime una lista de todos los pedidos */

        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pedido.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();

        try {
            actualSession.beginTransaction();

            List<Pedido> pedidos = actualSession.createQuery("from Pedido").getResultList();

            System.out.println("------------------------------------------------Lista de Pedidos---------------------------------------------------------");
            for (Pedido pe : pedidos) {
                System.out.println(pe);
            }

            actualSession.getTransaction().commit();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        } finally {
            actualSession.close();
        }


    }

}









