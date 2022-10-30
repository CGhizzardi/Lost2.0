package Vista;

import Controlador.controller;
import Controlador.controlArticulos;

import Modelo.Articulos;
import Modelo.ListaArticulos;
import Vista.GestionOs.*;
import java.util.Scanner;

public class ArticuloVista {

Scanner teclado = new Scanner(System.in);

public controlArticulos contArt;
protected controlArticulos contArt;
protected controller cont;



    /** Metodo constructor de la clase
     *
     * @param contArt
     */

    public ArticuloVista(controlArticulos contArt) {
        this.contArt = contArt;
    }

    public void gestionarticulos() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Añadir articulos");
            System.out.println("2. Mostrar articulos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
// TO-BE-DONE
                    break;
                case '2':
// TO-BE-DONE


    /** El metodo para imprimir los datos del articulo */


    public void ImprimirArt(){
        OnlineStore list = new OnlineStore();
        list.getGestion();
    }



public void imprimirArticulo(){







}





}
