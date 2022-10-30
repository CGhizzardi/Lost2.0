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
    public ArrayList<Articulos> getLista(ArrayList<Articulos> list) {
        return super.getLista(list);
    }

    @Override
    public void setLista(ArrayList<Articulos> lista) {
        super.setLista(lista);
    }

    @Override
    public void add(Articulos articulos) {
        super.add(articulos);
    }

    @Override
    public void borrar() {
        super.borrar();
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public Articulos getAt(int position) {
        return super.getAt(position);
    }

    @Override
    public void clear() {
        super.clear();
    }

    /*@Override
    public int isEmpty() {
    return super.isEmpty();
    }*/

    @Override
    public ArrayList<Articulos> setArrayList() {
        return super.setArrayList();
    }

    @Override
    public String toString() {
        return "ListaArticulo{" +
                "lista=" + lista +
                '}';
    }
}
