package Modelo;


/** Clase "ClientesEstandar" */

public class ClientesEstandar extends Clientes {

    /**
     * Metodo constructor de la clase
     *
     * @param name
     * @param addres
     * @param Nif
     * @param mail
     */



    public ClientesEstandar(String name, String addres, String Nif, String mail) {
        super(name, addres, Nif, mail);
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
        return "ClientesEstandar{}";
    }
}


