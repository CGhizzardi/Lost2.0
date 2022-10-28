package Modelo;

/** Clase abstracta "ClientesPremium" */

public class ClientesPremium extends Clientes {


    private double cuotaMensual;
    private double descuento;


    public ClientesPremium(String name, String Addres, String Nif, String mail, double cuotaMensual, double descuento) {
        super(name, Addres, Nif, mail);
        this.cuotaMensual = cuotaMensual;
        this.descuento = descuento;
    }
}



