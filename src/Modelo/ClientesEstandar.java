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
    public String toString() {
        return "ClientesEstandar{}";
    }
}


