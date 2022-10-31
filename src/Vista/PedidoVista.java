package Vista;

import Controlador.*;
import Modelo.Articulos;


import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class PedidoVista {

    protected controlPedidos contP;
    protected controlArticulos contArt;
    protected controller cont;
    protected ControlClientes contCli;


    public PedidoVista(controlPedidos contP, controlArticulos contArt, controller cont, ControlClientes contCli){

        this.contP=contP;
        this.contArt=contArt;
        this.cont=cont;
        this.contCli=contCli;
    }
    Scanner input = new Scanner(System.in);
    ClientesVista cliV=new ClientesVista();
    public void menuPedidos(){   //menu de pedidos
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
                    menuCrearPedido();
                    break;
                case 2:
                    menuEliminarPedido();
                    break;
                case 3:
                    menuMostrarPendientesEnvio();
                    break;
                case 4:
                    menuMostrarEnviados();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }
    public void menuCrearPedido(){
        System.out.println("Añade el numero de pedido: ");

                                                            //aqui esta el numero de pedido
        int numeroPedido= input.nextInt();
        System.out.println("CLIENTE: \n" +
                "1.Escoger cliente registrado.\n" +
                "2.Crear cliente nuevo.\n" +
                "OPCION= ");
        int opcion=0;
        do{
            opcion = input.nextInt();
            if(opcion==1){

                System.out.println("Lista de clientes: ");
               // contCli.mostrarCli();                                   //NO FUNCIONA!

                System.out.println("\nIntroduce el NIF del cliente: ");
                String nif = input.nextLine();
               // contCli.encontrarClientePorId(nif);


            }else if(opcion==2){
                //CREAR NUEVO CLIENTE!!!

                //SELECCIONARLO

            }
        }while(opcion!=1 && opcion!=2);


        //listar articulo y escoger el articulo.

        System.out.println("Introduce la cantidad de articulos: ");
                                                                    //aqui esta la cantidad!!
        int cantidadArticulos = input.nextInt();
                                                                    //aqui esta la fecha del pedido
        LocalDateTime fechaPedido = LocalDateTime.now();
                                                                    //precio total del pedido
        double precioTotal= contP.getPrecioTotal();




    }
    public void menuEliminarPedido(){

    }
    public void menuMostrarPendientesEnvio(){

    }
    public void menuMostrarEnviados(){

    }


    public void imprimirPedido (controlPedidos contP){


        System.out.println("numeroPedido=" + contP.getNumeroPedido()+"\n"+
                ", fechaHora=" + contP.getFechaHora()+"\n" +
                ", Nif del cliente=" + contP.getCliente().getNif()+"\n" +
                ", Nombre del Cliente=" + contP.getCliente().getNombre()+"\n" +
                ", Articulo codigo=" + contP.getArticulo().getCodigo()+"\n" +
                ", Descripción=" + contP.getArticulo().getDescripcion()+"\n" +
                ", Cantidad=" + contP.getCantidadArticulos()+"\n" +
                ", Articulo codigo=" + contP.getArticulo().getPrecioDeVenta()+"\n" +
                ", Envio=" + contP.getPrecioTotal() +" €\n"+
                ", Precio total=" + contP.getPrecioTotal() + " €\n"+
                ", El pedido esta enviado=" + contP.getEnviado()+"\n" +
                '}');
    }
}
