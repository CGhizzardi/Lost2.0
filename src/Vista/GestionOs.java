package Vista;

import Controlador.*;

import java.util.Scanner;
public class GestionOs {

    
    private controlPedidos contP;
    private controlArticulos contArt;
    private controller cont;
    private ControlClientes contCli;

    Scanner input = new Scanner(System.in);

    private controller controller;
    private ArticuloVista artV;

    private ClientesVista cliV;

    PedidoVista pedidoV = new PedidoVista(contP,contArt,cont, contCli);
    public GestionOs() {
        this.controller = new controller();
        this.artV= new ArticuloVista();
        this.cliV= new ClientesVista();
    }
    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                   artV.menuArticulos();
                    break;
                case '2':
                    cliV.menuCliente();
                    break;
                case '3':
                    pedidoV.menuCrearPedido();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
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


public controller getController(){
    return this.controller;
}
}