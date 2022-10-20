package lost.modelo;

import java.util.ArrayList;

public abstract class Lista<T> {

    protected ArrayList<T> lista;


    /** Metodo constructor */

    public Lista(ArrayList<T> lista) {
        this.lista = lista;
    }


    /** Metodos Getters y Setters */

    public ArrayList<T> getLista() {
        return lista;
    }

    public void setLista(ArrayList<T> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Lista{" + "lista=" + lista + '}';
    }
}