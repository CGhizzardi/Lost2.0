package Vista;
import Controlador.controlArticulos;
import Modelo.Articulos;
import Modelo.ListaArticulos;
import Vista.GestionOs.*;
import java.util.Scanner;


public class ArticuloVista {

    protected controlArticulos contArt;




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


    /** El metodo para imprimir los datos del articulo
     *
     * @param contArt
     * @return
     */


    public String printArticulo(controlArticulos contArt) {
        return "articulos{codigo=" + contArt.getCodigo()+ "\n"+
                "descripcion=" + contArt.getDescripcion() + "\n" +
                "precioDeVenta=" + contArt.getPrecioDeVenta()+ "\n" +
                "gastosDeEnvio=" + contArt.getGastosDeEnvio()+ "\n" +
                "tiempoDePreparacion=" + contArt.getTiempoDePreparacion()+ "\n";

    }





}
