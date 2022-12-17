package Vista;

import Controlador.ControlClientes;
import Controlador.Controller;

import java.util.Scanner;

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
                    controller.ormCrearPedidos();
                    break;
                case 2:
                    controller.menuEliminarPedido(user, pass);
                    break;
                case 3:
                    controller.menuMostrarPendientesEnvio(user, pass);
                    break;
                case 4:
                    controller.menuMostrarEnviados(user, pass);
                    break;
                case 5:
                    controller.menuMostrarPedido(user, pass);
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


