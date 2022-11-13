package Vista;


import Controlador.Controller;
import java.util.Scanner;


public class ArticuloVista {
    Scanner input= new Scanner(System.in);

    protected Controller controller;
    protected OnlineStore g;



    public ArticuloVista(){


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

        resp = input.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }


    public Controller getController() {
        return controller;
    }


}

