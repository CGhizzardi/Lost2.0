package Modelo;

/** Clase Articulo */

import java.sql.Time;
import java.util.Date;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



public class Articulos {
    private String codigo;
    private String descripcion;
    private double precioDeVenta;
    private double gastosDeEnvio;
    private int tiempoDePreparacion;

    public Articulos(String codigo, String descripcion, double precioDeVenta, double gastoDeEnvio, int tiempoDePrepar) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioDeVenta = precioDeVenta;
        this.gastosDeEnvio = gastoDeEnvio;
        this.tiempoDePreparacion = tiempoDePrepar;
    }

    public Articulos() {
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioDeVenta() {
        return this.precioDeVenta;
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public double getGastosDeEnvio() {
        return this.gastosDeEnvio;
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }

    public int getTiempoDePreparacion() {
        return this.tiempoDePreparacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String toString() {
        return "articulos{codigo='" + this.codigo + "', descripcion='" + this.descripcion + "', precioDeVenta=" + this.precioDeVenta + ", gastosDeEnvio=" + this.gastosDeEnvio + ", tiempoDePreparacion=" + this.tiempoDePreparacion + "}";
    }


}