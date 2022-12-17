package Dao;

import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class OrmCliente {

Scanner input= new Scanner(System.in);

    public OrmCliente(String user, String pass) {

    }

    public void menuInsCliente(String user, String pass) {
        boolean salir = false;
        char opcio;

        ClientesEstandar est;
        ClientesPremium premium;

        do {
            System.out.println("1. Añadir Clientes Estandar");
            System.out.println("2. Añadir Clientes Premium");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    est= crearCliE();
                    insClienteEs(est);
                    break;
                case '2':
                    premium= crearCliP();
                    insClientePr(premium);
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2 o 0):");
        resp = input.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    public ClientesPremium crearCliP(){   // metodo que crea un cliente premium
        String nif;
        String nombre;
        String domicilio;
        String email;
        double cuotaMensual;
        double descuento;

        System.out.println("Introduce el nif");
        nif= input.nextLine();

        System.out.println("Introduce el nombre");
        nombre= input.nextLine();

        System.out.println("Introduce el domicilio");
        domicilio= input.nextLine();

        System.out.println("Introduce el e-mail");
        email= input.nextLine();

        System.out.println("Introduce el cuota mensual");
        cuotaMensual= input.nextDouble();

        System.out.println("Introduce el descuento");
        descuento= input.nextDouble();

        ClientesPremium cp = new ClientesPremium(nif,nombre,domicilio, email, cuotaMensual,descuento);

        return cp;
    }

    public ClientesEstandar crearCliE(){   /** metodo que crea un cliente Estandar */
        String nif;
        String nombre;
        String domicilio;
        String email;

        System.out.println("Introduce el nif");
        nif= input.nextLine();

        System.out.println("Introduce el nombre");
        nombre= input.nextLine();

        System.out.println("Introduce el domicilio");
        domicilio= input.nextLine();

        System.out.println("Introduce el e-mail");
        email= input.nextLine();

        ClientesEstandar cE = new ClientesEstandar(nif,nombre,domicilio, email);

        return cE;
    }

    public void insClientePr(ClientesPremium premium){    /**Metodo que agrega un cliente premium */
         SessionFactory ormSession= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
         Session actualSession= ormSession.openSession();
        try {
            actualSession.beginTransaction();
            actualSession.save(premium);
            actualSession.getTransaction().commit();
            System.out.println("Cliente premium guardado");
        } catch (Exception e){


            System.out.println("error al guardar el cliente");
        } finally {
            actualSession.close();
        }
     }

    public void insClienteEs(ClientesEstandar estandar){  /** Metodo que inserta un cliente estandar */
        SessionFactory ormSession= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSession= ormSession.openSession();

        try {
            actualSession.beginTransaction();
            actualSession.save(estandar);
            actualSession.getTransaction().commit();
            System.out.println("Cliente Estandar guardado");
        } catch (Exception e){
            System.out.println("error al guardar el cliente");

    } finally {
            actualSession.close();
        }
    }

    public void imprimirClientesEstandar(){

        SessionFactory ormSession= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSession= ormSession.openSession();
try {
    actualSession.beginTransaction();

    List<ClientesEstandar> clienteEstandar = actualSession.createQuery("from Clientes cl where cl.cuataMensual != 0").getResultList();

    for (ClientesEstandar cEs:clienteEstandar) {

        System.out.println(cEs);
        
    }
} finally {
    actualSession.close();
}

    }
















}
