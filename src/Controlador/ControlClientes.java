package Controlador;

import Vista.*;
import Modelo.*;


public class ControlClientes {

    private Clientes modelo;
    private Clientes vista;
    controller c = new controller();
    //CONSTRUCTOR
    public ControlClientes(Clientes modelo, Clientes vista) {
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

    public void mostrarCli(){
        int i=1;
        System.out.println("CLIENTES ESTANDAR:\n");     //MUESTRA CLIENTES ESTANDAR
        for (ClientesEstandar clientesEstandar : c.listaClientesEstandar){
            System.out.println("clientesEstandar numero "+i+"= " + clientesEstandar);
            i++;
        }
        i=1;
        System.out.println("CLIENTES PREMIUM:\n");     //MUESTRA CLIENTES PREMIUM
        for (ClientesPremium clientesPremium : c.listaClientesPremium){
            System.out.println("clientesPremium numero "+i+"= " + clientesPremium);
            i++;
        }
    }
    public Clientes encontrarClientePorId(String NIF){                  //DEVUELVE 1 CLIENTE, ENTRANDO EL NIF
        for (ClientesEstandar clientesEstandar : c.listaClientesEstandar){
            if (NIF == clientesEstandar.getNif()){
                return clientesEstandar;
            }
        }
        for (ClientesPremium clientesPremium : c.listaClientesPremium){
            if (NIF == clientesPremium.getNif()){
                return clientesPremium;
            }
        }
        return null;
    }
}