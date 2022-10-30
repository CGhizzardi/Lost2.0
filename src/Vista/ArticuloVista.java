package Vista;

import Controlador.controller;
import Controlador.controlArticulos;
import Vista.GestionOs.*;

import java.util.Scanner;


public class ArticuloVista {
Scanner input= new Scanner(System.in);
    protected controlArticulos contArt;
    protected controller cont;


    /** Metodo constructor de la clase
     *
     * @param contArt
     */

    public ArticuloVista(controlArticulos contArt){

        this.contArt=contArt;


    }

            public void menuArticulos() {
            boolean salir = false;
            char opcio;
            do {
                System.out.println("1. Añadir Cliente");
                System.out.println("2. Gestión Clientes");
                System.out.println("0. Salir");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':


// TO-BE-DONE
                        break;
                    case '2':
                        System.out.println("Imprimir Articulo");
                        cont.MostrarArticulo();
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









    /** El metodo para imprimir los datos del articulo */

    public void ImprimirArt(){
        OnlineStore list = new OnlineStore();
        list.getGestion();
    }



public void imprimirArticulo(){







}





}
