package Dao;

import Modelo.Articulos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class OrmArticulos {

    Scanner input = new Scanner(System.in);

    public OrmArticulos(String user, String pass) {

    }

    public Articulos crearArticulo() {   // metodo que crea un cliente premium
        String codigo;
        String descripcion;
        double precioVenta;
        double envio;
        int tiempo;

        System.out.println("Introduce el codigo");
        codigo = input.nextLine();

        System.out.println("Introduce el descripcion");
        descripcion = input.nextLine();

        System.out.println("Introduce el precioVenta");
        precioVenta = input.nextDouble();

        System.out.println("Introduce el coste/envio");
        envio = input.nextDouble();

        System.out.println("Introduce el tiempo preparacion");
        tiempo = input.nextInt();

        Articulos articulo = new Articulos(codigo, descripcion, precioVenta, envio, tiempo);

        return articulo;
    }

    public void insArticulo(Articulos articulo) {    /**Metodo que agrega un articulo */
        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulos.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();
        try {
            actualSession.beginTransaction();
            actualSession.save(articulo);
            actualSession.getTransaction().commit();
            System.out.println("Articulo guardado");
        } catch (Exception e) {


            System.out.println("error al guardar el articulo");
        } finally {
            actualSession.close();
        }
    }


    public void ormImprimirArticulos() {

        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulos.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();
        try {
            actualSession.beginTransaction();
            List<Articulos> articulos = actualSession.createQuery("from Articulos").getResultList();
            System.out.println(articulos);
        } finally {
            actualSession.close();
        }

    }


    public Articulos ormObtenerArticulo(){

        Articulos ar;
        String codArt;
        String seleccion;
        ormImprimirArticulos();
        System.out.println("Ingrese el codigo del articulo deseado");
        seleccion= input.nextLine();
        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulos.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();
        try {
            actualSession.beginTransaction();
            ar = actualSession.get(Articulos.class, seleccion);
            actualSession.getTransaction().commit();
        } finally {
            actualSession.close();
        }


        return ar;
    }






}