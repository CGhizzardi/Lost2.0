package Controlador;
import Vista.*;
import Modelo.*;

import java.util.Scanner;


public class ControlArticulos {
    Scanner input = new Scanner(System.in);


    private Articulos artModel;
    private ArticuloVista artVista;


    /**
     * Metodo constructor de la clase
     *
     * @param artModel
     * @param artVista
     */


    public ControlArticulos(Articulos artModel, ArticuloVista artVista) {
        this.artModel = artModel;
        this.artVista = artVista;
    }

    /**
     * Metodos Getters y Setters
     *
     * @return
     */


    public String getCodigo() {
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

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        artModel.setTiempoDePreparacion((int) tiempoDePreparacion);
    }

    public String getDescripcion() {
        return artModel.getDescripcion();
    }

    public void setDescripcion(String descripcion) {
        artModel.setDescripcion(descripcion);
    }


    /**
     * Metodo que muestra el articulo
     *
     * @return
     */








    }






