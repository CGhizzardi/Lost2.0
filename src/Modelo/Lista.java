package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista<T> {

    Scanner input = new Scanner(System.in);
    protected ArrayList<T> lista;


    /**
     * Metodo constructor
     */

    public Lista(ArrayList<T> lista) {
        this.lista = new ArrayList<T>();

    }

    /**
     * Metodos Getters y Setters
     */
    public ArrayList<T> getLista() {
        return lista;
    }

    public void setLista(ArrayList<T> lista) {
        this.lista = lista;
    }

    /** Metodos de la clase para los arrayList **/

    /**
     * Agregar objeto al ArrayList
     *
     * @param t
     */
    public void add(T t) {
        lista.add(t);
    }


    /** Borrar objetos del Arraylist
     *
     */

    public void borrar() {

        int i;
        int index;
        System.out.println("Seleccione el numero del objeto que desea borrar");

        /** Bucle que imprime la lista de elemntos que contieene el ArrayList y su indice **/
        for (i = 0; i < lista.size(); i++) {
            System.out.println(i + " " + lista.get(i));
        }

        index = input.nextInt();
        lista.remove(index);
    }


    /**
     * obtener el tamaño o longitud del ArrayList
     *
     * @return
     */
    public int getSize() {
        int arrListSize = lista.size();
        return arrListSize;
    }


    @Override
    public String toString() {
        return "Lista{" + "lista=" + lista + '}';
    }
}