package lost.modelo;

/** Clase abstracta "ClientesPremium" */

public class ClientesPremium extends Clientes {


    /**
     * Metodo constructor de la clase
     *
     * @param name
     * @param addres
     * @param Nif
     * @param mail
     */
    public ClientesPremium(String name, String addres, String Nif, String mail, double cuotaMensual, double descuento) {
        super(name, addres, Nif, mail, cuotaMensual, descuento);
    }


}


