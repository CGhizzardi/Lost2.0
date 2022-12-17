package Dao;


import Controlador.Controller;
import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;

import java.util.Scanner;

public class OrmPedidos {

    Scanner input = new Scanner(System.in);

    public OrmPedidos() {
    }

    public void ormAgregarPedido() {

        System.out.println("Por favor seleccione un cliente o  agregue uno");


    }

    public String ormSeleccionarNifCliente(String user, String pass) {
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
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':   /** Opcion de crear un cliente */
                    nif=cliente.crearClientePedido(user, pass);
                    break;
                case '2':  /** Opcion de seleccionar un cliente en lugar de crearlo */
                    c.ormMostarClientes(user, pass);
                    do {
                        System.out.println("A que tipo de cliente desea facturar?");
                        System.out.println("1. Elegir Clientes Estandar");
                        System.out.println("2. Elegir Clientes Premium");
                        opcion = pedirOpcion();
                        switch (opcion) {
                            case '1':
                                ClientesEstandar ces = cliente.ormObtenerCE(user, pass);
                                nif = cliente.nifClienteES(ces);
                                salir = true;
                                break;
                            case '2':
                                ClientesPremium cpr = cliente.ormObtenerPR(user, pass);
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
}








