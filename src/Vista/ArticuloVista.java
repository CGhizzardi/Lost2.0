package Vista;

import Controlador.controlArticulos;
import Controlador.controller;
import Modelo.Articulos;


import java.util.Scanner;


public class ArticuloVista {
    Scanner input= new Scanner(System.in);
    protected controlArticulos contArt;
    protected controller controllerV;
    protected OnlineStore g;



    public ArticuloVista(){

        this.contArt=contArt;
        this.controllerV= new controller();

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


// TO-BE-DONE
                    break;
                case '2':
                    controllerV.MostrarArticulo();
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





    public void imprimirArticulo(){







    }





}

