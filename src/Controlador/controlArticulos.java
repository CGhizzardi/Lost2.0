package Controlador;
import Vista.*;
import Modelo.*;
import java.time.*;

public class controlArticulos {

    private Articulos artModel;
    private ArticuloVista artVista;

    /**Metodo constructor de la clase
     *
     * @param artModel
     * @param artVista
     */


    public controlArticulos(Articulos artModel, ArticuloVista artVista) {
        this.artModel = artModel;
        this.artVista = artVista;
    }

    /** Metodos Getters y Setters
     *
     * @return
     */



    public String getCodigo(){
        return artModel.getCodigo();
    }

    public void setCodigo(String codigo) {
        artModel.setCodigo(codigo);
    }


    public double getPrecioDeVenta() {
        return artModel.getPrecioDeVenta();
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        artModel.setPrecioDeVenta(precioDeVenta);
    }

    public double getGastosDeEnvio() {
        return artModel.getGastosDeEnvio();
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        artModel.setGastosDeEnvio(gastosDeEnvio);
    }

    public long getTiempoDePreparacion() {
        return artModel.getTiempoDePreparacion();
    }

    public void setTiempoDePreparacion(long tiempoDePreparacion) {
        artModel.setTiempoDePreparacion(tiempoDePreparacion);}

    public String getDescripcion() {return artModel.getDescripcion();}

    public void setDescripcion(String descripcion) {
        artModel.setDescripcion(descripcion);
    }


    /** Metodo que muestra el articulo
     *
     * @return
     */

    public String MostrarArticulo() {
        System.out.println("Introduce el nombre del articulo que deseas mostrar");


        return "articulos{codigo=" + artModel.getCodigo()+ "\n"+
                "descripcion=" + artModel.getDescripcion() + "\n" +
                "precioDeVenta=" + artModel.getPrecioDeVenta()+ "\n" +
                "gastosDeEnvio=" + artModel.getGastosDeEnvio()+ "\n" +
                "tiempoDePreparacion=" + artModel.getTiempoDePreparacion()+ "\n";
    }

/** Metodos para la vista*/




}
