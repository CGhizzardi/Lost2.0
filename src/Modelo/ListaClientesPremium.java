package Modelo;

import java.util.ArrayList;

public class ListaClientesPremium extends Lista<ClientesPremium> {



    /** Metodo Constructor
     *
     * @param lista
     */
    public ListaClientesPremium(ArrayList<ClientesPremium> lista) {
        super(lista);
    }




    @Override
    public String toString() {
        return "ListaClientesEstandar{" +
                "lista=" + lista +
                '}';
    }
}
