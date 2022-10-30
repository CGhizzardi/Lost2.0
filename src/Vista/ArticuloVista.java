package Vista;
import Controlador.controlArticulos;
import Modelo.Articulos;
import Modelo.ListaArticulos;

import java.util.Scanner;

public class ArticuloVista {

    public controlArticulos contArt;
    Scanner teclado = new Scanner(System.in);




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

                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2 o 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
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
