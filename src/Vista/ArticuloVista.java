package Vista;

import Controlador.controller;
import Controlador.controlArticulos;
import Vista.GestionOs.*;


public class ArticuloVista {

    protected controlArticulos contArt;
    protected controller cont;


    /** Metodo constructor de la clase
     *
     * @param contArt
     */

    public ArticuloVista(controlArticulos contArt){

        this.contArt=contArt;

    }


    /** El metodo para imprimir los datos del articulo */

    public void ImprimirArt(){
        OnlineStore list = new OnlineStore();
        list.getGestion();
    }



public void imprimirArticulo(){







}





}
