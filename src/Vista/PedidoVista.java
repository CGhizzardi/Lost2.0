package Vista;

import Controlador.*;


import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class PedidoVista {


    protected Controller controller;
    protected ControlClientes contCli;


    public PedidoVista() {


        this.controller = new Controller();
        this.contCli = contCli;
    }

    Scanner input = new Scanner(System.in);
    ClientesVista cliV = new ClientesVista();

    public void menuPedidos() {   //menu de pedidos
        boolean salir = false;
        do {
            System.out.println("ESTA ES LA GESTION DE PEDIDOS:\n");
            System.out.println("1. Añadir pedido.");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostras pedidos pendientes de envio");
            System.out.println("4. Mostras pedidos enviados");
            System.out.println("0. Salir");

            int resp;
            System.out.println("Elige una opción (1,2,3,4 o 0):");

            resp = input.nextInt();

            switch (resp) {
                case 1:
                    controller.menuCrearPedido();
                    break;
                case 2:
                    controller.menuEliminarPedido();
                    break;
                case 3:
                    controller.menuMostrarPendientesEnvio();
                    break;
                case 4:
                    controller.menuMostrarEnviados();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    public void menuCrearPedido() {
        System.out.println("Añade el numero de pedido: ");

        //aqui esta el numero de pedido
        int numeroPedido = input.nextInt();
        System.out.println("CLIENTE: \n" +
                "1.Escoger cliente registrado.\n" +
                "2.Crear cliente nuevo.\n" +
                "OPCION= ");
        int opcion = 0;
        do {
            opcion = input.nextInt();
            if (opcion == 1) {

                System.out.println("Lista de clientes: ");
                // contCli.mostrarCli();                                   //NO FUNCIONA!

                System.out.println("\nIntroduce el NIF del cliente: ");
                String nif = input.nextLine();
                // contCli.encontrarClientePorId(nif);


            } else if (opcion == 2) {
                //CREAR NUEVO CLIENTE!!!

                //SELECCIONARLO

            }
        } while (opcion != 1 && opcion != 2);


        //listar articulo y escoger el articulo.

        System.out.println("Introduce la cantidad de articulos: ");
        //aqui esta la cantidad!!
        int cantidadArticulos = input.nextInt();
        //aqui esta la fecha del pedido
        LocalDateTime fechaPedido = LocalDateTime.now();
        //precio total del pedido



    }


    public Controller getContolador() {
        return controller;
    }

}


