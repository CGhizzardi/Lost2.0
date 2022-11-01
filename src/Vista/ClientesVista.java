package Vista;

import Controlador.*;
import Modelo.ListaArticulos;
import Modelo.ListaClientesEstandar;
import Modelo.ListaClientesPremium;

import java.util.Scanner;

public class ClientesVista {

    Scanner input= new Scanner(System.in);

    private Controller controller;

    public ClientesVista(){
        this.controller= new Controller();
    }


    public void menuCliente() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Añadir Clientes");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Estandar");
            System.out.println("4. Mostrar Clientes Premium");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    controller.addCliente();
                    break;
                case '2':
                    controller.mostrarCli();
                    break;
                case '3':
                    controller.mostrarCliEs();
                    break;
                case '4':
                    controller.mostrarCliPr();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2 o 0):");
        resp = input.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }




    public void imprimirClientes (ControlClientes clientes){
        System.out.println("Nombre del cliente: " + clientes.getNombre() + "\n" +
                "Dirección: " + clientes.getDomicilio() + "\n" +
                "NIF: " + clientes.getNif() + "\n" +
                "Mail: " + clientes.getEmail() + "\n");
        if(clientes.getDescuento() > 0 ){
            System.out.println("Cliente Premium \n " +
                    "Descuento: " + clientes.getDescuento() + "\n" +
                    "Cuota Anual: " + clientes.getCuota() + "\n");
        }else {
            System.out.println("Cliente estandar \n");
        }
    }

    public ListaClientesPremium getListaClientesPremium(){
        return controller.getDatosPr().getListaClientesPremium();

    }
//public void setListaArticulos(ListaArticulos a){


    public ListaClientesEstandar getListaClientesEstandar(){
        return controller.getDatosPr().getListaClientesEstandar();
    }

}
/**GESTION DE CLIENTES - EN EL MENU
 * AÑADIR CLIENTE
 * MOSTRAR CLIENTE
 * MOSTRAR CLIENTE PREMIUM
 * MOSTRAR CLIENTE ESTANDAR*/    /**R */