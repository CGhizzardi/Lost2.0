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
    public ArrayList<ClientesEstandar> getLista(ArrayList<ClientesEstandar> list) {
        return super.getLista(list);
    }

    @Override
    public void setLista(ArrayList<ClientesEstandar> lista) {
        super.setLista(lista);
    }

    @Override
    public void add(ClientesEstandar clientesEstandar) {
        super.add(clientesEstandar);
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
    public ClientesEstandar getArt(int position) {
        return super.getArt(position);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public ArrayList<ClientesEstandar> setArrayList() {
        return super.setArrayList();
    }

    @Override
    public String toString() {
        return "ListaClientesEstandar{" +
                "lista=" + lista +
                '}';
    }
}
