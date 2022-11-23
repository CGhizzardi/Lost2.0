package Vista;

import Controlador.*;
import Vista.ArticuloVista.*;

import java.util.Scanner;
public class GestionOs {

    Scanner input = new Scanner(System.in);
    Controller cont = new Controller();


    private ArticuloVista artV;
    private ClientesVista cliV;
    private PedidoVista pedV;



    PedidoVista pedidoV = new PedidoVista();
    public GestionOs() {

        this.artV= new ArticuloVista();
        this.cliV= new ClientesVista();
        this.pedidoV= new PedidoVista();

    }

    public void inicio() {
        boolean salir = false;
        char opcio;
        String user=cont.USUARIO();
        String pass= cont.PASSWORD();
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                   artV.menuArticulos(user,pass);
                   //pedidoV.getContolador().getDatosPr().setListaArticulos(artV.getController().getArticulosList());
                    break;
                case '2':
                    cliV.menuCliente(user, pass);
                    //pedidoV.getContolador().getDatosPr().setListaClientesEstandar(cliV.getController().getClientesEsList());
                    //pedidoV.getContolador().getDatosPr().setListaClientesPremium(cliV.getController().getClientesPreList());
                    break;
                case '3':
                    pedidoV.menuPedidos(user, pass);
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



}