package Vista;

import Controlador.ControlArticulos;
import Controlador.Controller;


import java.util.Scanner;


public class ArticuloVista {
    Scanner input= new Scanner(System.in);
    protected ControlArticulos contArt;
    protected Controller controller;
    protected OnlineStore g;



    public ArticuloVista(){

        this.contArt=contArt;
        this.controller= new Controller();

    }

    public void menuArticulos() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Añadir Articulo");
            System.out.println("2. Imprimir Articulo");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    controller.addarticulo();
                    break;
                case '2':
                    controller.MostrarArticulo();
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









    /** El metodo para imprimir los datos del articulo */





    public void imprimirArticulo(){







    }





}

