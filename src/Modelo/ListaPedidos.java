package Modelo;

import java.util.ArrayList;

public class ListaPedidos extends Lista<Pedidos>{
    /**
     * Metodo constructor
     *
     * @param lista
     */
    public ListaPedidos(ArrayList<Pedidos> lista) {
        super(lista);
    }

    @Override
    public String toString() {
        return "ListaPedidos{" +
                "lista=" + lista +
                '}';
    }
}
