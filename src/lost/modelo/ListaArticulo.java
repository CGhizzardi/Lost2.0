package lost.modelo;

import java.util.ArrayList;

public class ListaArticulo extends Lista {
    /**
     * Metodo constructor
     *
     * @param lista
     */
    public ListaArticulo(ArrayList<Articulos> lista) {
        super(lista);
    }

    @Override
    public String toString() {
        return "ListaArticulo{" +
                "lista=" + lista +
                '}';
    }
}
