package lost.modelo;

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
    public ClientesEstandar(String name, String addres, String Nif, String mail, double cuotaMensual, double descuento) {
        super(name, addres, Nif, mail,cuotaMensual, descuento);
    }


}


