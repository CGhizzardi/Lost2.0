package Controlador;

import Vista.*;
import Modelo.*;
import Controlador.controller.*;
import java.util.*;



public class ControlClientes {
    private Clientes modelo;
    private ClientesVista vista;


    //CONSTRUCTOR
    public ControlClientes(Clientes modelo, ClientesVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void setNombre(String nombre) {
        modelo.setNombre(nombre);
    }
    public String getNombre() {
        return modelo.getNombre();
    }

    public void setDomicilio(String domicilio) {
        modelo.setDomicilio(domicilio);
    }

    public String getDomicilio() {
        return modelo.getDomicilio();
    }

    public void setNif(String nif) {
        modelo.setNif(nif);
    }

    public String getNif() {
        return modelo.getNif();
    }

    public void setEmail(String email) {
        modelo.setEmail(email);
    }

    public String getEmail() {
        return modelo.getEmail();
    }

    public void setCuota(double cuota) {
        modelo.setCuota(cuota);
    }

    public double getCuota() {
        return modelo.getCuota();
    }

    public void setDescuento(double descuento) {
        modelo.setDescuento(descuento);
    }

    public double getDescuento() {
        return modelo.getDescuento();
    }

}