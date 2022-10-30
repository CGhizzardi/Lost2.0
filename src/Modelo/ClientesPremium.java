package Modelo;

/** Clase abstracta "ClientesPremium" */

public class ClientesPremium extends Clientes {


    public ClientesPremium(String name, String Ad, String Nif, String mail, double quota, double desc) {
        super(name, Ad, Nif, mail, quota, desc);
    }

    @Override
    public Clientes copiaCliente(Clientes clientes) {
        return null;
    }

    @Override
    public String tipoCliente() {
        return null;
    }

    @Override
    public float calcAnual() {
        return 0;
    }

    @Override
    public float descuentoEnv() {
        return 0;
    }


    @Override
    public String toString() {
        return "ClientesPremium{}";
    }
}






