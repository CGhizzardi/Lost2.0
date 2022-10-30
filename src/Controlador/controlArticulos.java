package Controlador;
import Vista.*;
import Modelo.*;
import java.time.*;
import java.util.Scanner;
import Controlador.controller.*;
import java.util.*;



public class controlArticulos {
    Scanner input = new Scanner(System.in);


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


    public void addarticulo (Articulos art, ListaArticulos list) {
        Scanner teclado = new Scanner(System.in);
        String codigo, descripcion;
        double precio, envio;
        long tiempo;

        codigo = teclado.nextLine();
        descripcion = teclado.nextLine();
        precio = teclado.nextDouble();
        envio = teclado.nextDouble();
        tiempo = teclado.nextLong();

        art.setCodigo(codigo);
        art.setDescripcion(descripcion);
        art.setPrecioDeVenta(precio);
        art.setGastosDeEnvio(envio);
        art.setTiempoDePreparacion(tiempo);
        list.add(art);

    }
    /** Metodo que muestra el articulo
     *
     * @return
     */
    public String MostrarArticulo() {
        System.out.println("Introduce el nombre del articulo que deseas mostrar");

    public String articuloToString() {


        return  "articulos codigo=" + artModel.getCodigo()+ "\n"+
                "descripcion=" + artModel.getDescripcion() + "\n" +
                "precioDeVenta=" + artModel.getPrecioDeVenta()+ "\n" +
                "gastosDeEnvio=" + artModel.getGastosDeEnvio()+ "\n" +
                "tiempoDePreparacion=" + artModel.getTiempoDePreparacion()+ "\n";
    }







}
