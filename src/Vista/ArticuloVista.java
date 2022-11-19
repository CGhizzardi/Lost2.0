package Vista;


import Controlador.Controller;
import java.util.Scanner;
import Dao.*;


public class ArticuloVista {
    Scanner input= new Scanner(System.in);

    protected Controller controller;
    protected OnlineStore g;



    public ArticuloVista(){


        this.controller= new Controller();

    }

    public void menuArticulos(String user, String pass) {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Añadir Articulo");
            System.out.println("2. Imprimir Articulo");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':

                    controller.addarticulo(user, pass);
                    break;
                case '2':
                    controller.MostrarArticulo(user, pass);
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

