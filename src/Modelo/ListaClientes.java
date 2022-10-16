package Modelo;

import java.util.ArrayList;

public class ListaClientes extends Lista {
    /**
     * Metodo constructor
     *
     * @param lista
     */
    public ListaClientes(ArrayList<Clientes> lista) {
        super(lista);
    }



    @Override
    public String toString() {
        return "ListaClientes{" +
                "lista=" + lista +
                '}';
    }
}
