package Modelo;

/** Clase abstracta "ClientesPremium" */

public class ClientesPremium extends Clientes {


    public ClientesPremium(String name, String Ad, String Nif, String mail, double quota, double desc) {
        super(name, Ad, Nif, mail, quota, desc);
    }


    @Override
    public String toString() {
        return "ClientesPremium{}";
    }
}






