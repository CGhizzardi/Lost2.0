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

    public void menuPedidos(String user, String pass) {   //menu de pedidos
        boolean salir = false;
        do {
            System.out.println("ESTA ES LA GESTION DE PEDIDOS:\n");
            System.out.println("1. Añadir pedido.");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostrar pedidos pendientes de envio");
            System.out.println("4. Mostrar pedidos enviados");
            System.out.println("5. Mostrar un pedido");
            System.out.println("0. Salir");

            int resp;
            System.out.println("Elige una opción (1,2,3,4 o 0):");

            resp = input.nextInt();

            switch (resp) {
                case 1:
                    controller.menuCrearPedido(user, pass);
                    break;
                case 2:
                    controller.menuEliminarPedido(user, pass);
                    break;
                case 3:
                    controller.menuMostrarPendientesEnvio();
                    break;
                case 4:
                    controller.menuMostrarEnviados();
                    break;
                case 5:
                    controller.menuMostrarPedido();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    public Controller getContolador() {
        return controller;
    }

}


