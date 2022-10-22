package Modelo;

import java.util.ArrayList;

public class ListaArticulos extends Lista<Articulos> {

    /** Metodo Constructor
     *
     * @param lista
     */


    public ListaArticulos(ArrayList<Articulos> lista) {
        super(lista);
    }

    @Override
    public String toString() {
        return "ListaArticulo{" +
                "lista=" + lista +
                '}';
    }
}
