package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public  class Lista<T> {

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
    public ArrayList<T> getLista(ArrayList<T> list) {
        return list;
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

    /** obtener un objeto especifico del arrayList
     *
     * @param position
     * @return
     */

    public T getArt(int position) {
        T objeto= lista.get(position);
        return objeto;
    }



    //https://docs.oracle.com/javase/7/docs/api/

    public void clear() {
        //void clear()
        //Removes all of the elements from this list (optional operation)-Quita todos los elementos de esta lista (operación opcional).
        //The list will be empty after this call returns.
        lista.clear();

    }
    public boolean isEmpty() {
        //boolean isEmpty()
        //Returns true if this list contains no elements.
        if(lista.isEmpty() == true){
            System.out.println("Esta lista está vacía");
            return true;
        }
        System.out.println("Esta lista contiene elementos");
        return false;
    }


    /** metodo que crea y devuelve un arrayList
     *
     * @return
     */
    public ArrayList<T> setArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }

    public void EliminarConArgumento(int a) {

        lista.remove(a);
    }


    @Override
    public String toString() {
        return "Lista{" + "lista=" + lista + '}';
    }
}