package Vista;
import Controlador.controlArticulos;

public class ArticuloVista {

    protected controlArticulos contArt;


    /** Metodo constructor de la clase
     *
     * @param contArt
     */

    public ArticuloVista(controlArticulos contArt){

        this.contArt=contArt;

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
