package Modelo;

import java.util.ArrayList;

public class ListaClientesEstandar extends Lista<ClientesEstandar> {



    /** Metodo Constructor
     *
     * @param lista
     */
    public ListaClientesEstandar(ArrayList<ClientesEstandar> lista) {
        super(lista);
    }




    @Override
    public String toString() {
        return "ListaClientesEstandar{" +
                "lista=" + lista +
                '}';
    }
}
