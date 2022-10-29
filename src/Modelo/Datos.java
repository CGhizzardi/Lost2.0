package Modelo;

import java.util.ArrayList;

/** Clase que contiene todos las operaciones para el controlador */


public class Datos {
    protected ListaArticulos listaArticulos;
    protected ListaClientesEstandar listaClientesEstandar;
    protected ListaClientesPremium listaClientesPremium;
    protected ListaPedidos listaPedidos;


    /** Metodo constructor de la clase Datos
     *
     */


    public Datos(ListaArticulos listaArticulos,ListaClientesEstandar listaClientesEstandar, ListaClientesPremium listaClientesPremium, ListaPedidos listaPedidos) {
        this.listaArticulos = listaArticulos;
        this.listaClientesEstandar = listaClientesEstandar;
        this.listaClientesPremium = listaClientesPremium;
        this.listaPedidos = listaPedidos;
    }

    /** Metodos Getters y Setters
     *
     * @return
     */


    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ListaArticulos listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ListaClientesEstandar getListaClientesEstandar() {
        return listaClientesEstandar;
    }

    public void setListaClientesEstandar(ListaClientesEstandar listaClientesEstandar) {
        this.listaClientesEstandar = listaClientesEstandar;
    }

    public ListaClientesPremium getListaClientesPremium() {
        return listaClientesPremium;
    }

    public void setListaClientesPremium(ListaClientesPremium listaClientesPremium) {
        this.listaClientesPremium = listaClientesPremium;
    }

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ListaPedidos listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    /** Metodo que carga datos automaticamente en nuestro programa simulando una BBDD
     *
     */

    public void datosPrograma(){

/** Carga de Articulos **/
        Articulos LibCocina= new Articulos("lib0001","Libro de Cocina", 10.50, 3.00,45);
        Articulos LibTerror= new Articulos("lib0002","Evangelio del Mal", 21.50, 3.00,60);
        Articulos LibInfantil= new Articulos("lib0003","El Gato con Botas", 8.30, 3.00,25);
        Articulos LibHistoria= new Articulos("lib0004","Edad Media", 10.50, 3.00,80);
        Articulos LibBricolage= new Articulos("lib0005","Manitas para Dummies", 14.50, 3.00,5);

        ArrayList<Articulos> artiP= new ArrayList<Articulos>();
        artiP.add(LibBricolage);
        artiP.add(LibCocina);
        artiP.add(LibTerror);
        artiP.add(LibInfantil);
        artiP.add(LibHistoria);

        listaArticulos.lista= artiP;


        /**Carga de Clientes **/

        ClientesPremium MLopez= new ClientesPremium("Manuel Lopez", "Barcelona", "E2216876l", "mLopez@hotmail.com", 40,10);
        ClientesPremium DTerrago= new ClientesPremium("Dicac Terrago", "Barcelona", "D7549630n", "dTerrago@hotmail.com", 45,20);
        ClientesEstandar PMacron= new ClientesEstandar("Pier Macron", "Paris", "F2239015l", "pMacron@hotmail.com");
        ClientesEstandar SPlana= new ClientesEstandar("Sara Plana", "Bilbao", "R8007153s", "sPlana@hotmail.com");

        ArrayList<ClientesPremium> clienP= new ArrayList<ClientesPremium>();
        clienP.add(MLopez);
        clienP.add(DTerrago);
        listaClientesPremium.lista= clienP;

        ArrayList<ClientesEstandar> clienE= new ArrayList<ClientesEstandar>();
        clienE.add(PMacron);
        clienE.add(SPlana);
        listaClientesEstandar.lista=clienE;




    }

}
