package Dao;

import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class OrmCliente {

    Scanner input = new Scanner(System.in);

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
                    est = crearCliE();
                    insClienteEs(est);
                    break;
                case '2':
                    premium = crearCliP();
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

    public ClientesPremium crearCliP() {   // metodo que crea un cliente premium
        String nif;
        String nombre;
        String domicilio;
        String email;
        float cuotaMensual;
        float descuento;

        System.out.println("Introduce el nif");
        nif = input.nextLine();

        System.out.println("Introduce el nombre");
        nombre = input.nextLine();

        System.out.println("Introduce el domicilio");
        domicilio = input.nextLine();

        System.out.println("Introduce el e-mail");
        email = input.nextLine();

        System.out.println("Introduce el cuota mensual");
        cuotaMensual = input.nextFloat();

        System.out.println("Introduce el descuento");
        descuento = input.nextFloat();

        ClientesPremium cp = new ClientesPremium(nif, nombre, domicilio, email, cuotaMensual, descuento);

        return cp;
    }

    public ClientesEstandar crearCliE() {   /** metodo que crea un cliente Estandar */
        String nif;
        String nombre;
        String domicilio;
        String email;

        System.out.println("Introduce el nif");
        nif = input.nextLine();

        System.out.println("Introduce el nombre");
        nombre = input.nextLine();

        System.out.println("Introduce el domicilio");
        domicilio = input.nextLine();

        System.out.println("Introduce el e-mail");
        email = input.nextLine();

        ClientesEstandar cE = new ClientesEstandar(nif, nombre, domicilio, email);

        return cE;
    }

    public void insClientePr(ClientesPremium premium) {    /**Metodo que agrega un cliente premium */
        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();
        try {
            actualSession.beginTransaction();
            actualSession.save(premium);
            actualSession.getTransaction().commit();
            System.out.println("Cliente premium guardado");
        } catch (Exception e) {


            System.out.println("error al guardar el cliente");
        } finally {
            actualSession.close();
        }
    }

    public void insClienteEs(ClientesEstandar estandar) {  /** Metodo que inserta un cliente estandar */
        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();

        try {
            actualSession.beginTransaction();
            actualSession.save(estandar);
            actualSession.getTransaction().commit();
            System.out.println("Cliente Estandar guardado");
        } catch (Exception e) {
            System.out.println("error al guardar el cliente");

        } finally {
            actualSession.close();
        }
    }

    public void ormImprimirClientesEstandar() {

        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();
        try {
            actualSession.beginTransaction();
            List<ClientesEstandar> clienteEstandar = actualSession.createQuery("from ClientesEstandar where descuento=0").getResultList();

            System.out.println("------------------------------------------------Lista de clientes Estandar-----------------------------------------------");
            for (ClientesEstandar cEs : clienteEstandar) {
                System.out.println(cEs);
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            actualSession.getTransaction().commit();
        } finally {
            actualSession.close();
        }
    }

    public void ormImprimirClientesPremium() {  /** Imprime una linta de todos los clientes Premium */

        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();

        try {
            actualSession.beginTransaction();

            List<ClientesPremium> clienteP = actualSession.createQuery("from ClientesPremium where descuento!=0").getResultList();

            System.out.println("------------------------------------------------Lista de clientes Premium------------------------------------------------");
            for (ClientesPremium cPs : clienteP) {
                System.out.println(cPs);
            }

            actualSession.getTransaction().commit();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        } finally {
            actualSession.close();
        }


    }

    public void ormImprimirClientes() {   /** Imprime todos los clientes de la base de datos */

        List<ClientesPremium> clienteP;
        List<ClientesEstandar> clienteEstandar;

        SessionFactory ormSession = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSession = ormSession.openSession();

        try {
            actualSession.beginTransaction();

            clienteEstandar = actualSession.createQuery("from ClientesEstandar where descuento=0").getResultList();
            actualSession.getTransaction().commit();
        } finally {
            actualSession.close();
        }


        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();

        try {
            actualSessions.beginTransaction();

            clienteP = actualSessions.createQuery("from ClientesPremium where descuento!=0").getResultList();
            actualSessions.getTransaction().commit();
        } finally {
            actualSessions.close();
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("------------------------------------------------Lista de clientes Premium------------------------------------------------");
        for (ClientesPremium cPs : clienteP) {
            System.out.println(cPs);

        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        System.out.println("------------------------------------------------Lista de clientes Estandar-----------------------------------------------");
        for (ClientesEstandar cEs : clienteEstandar) {
            System.out.println(cEs);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }


    public void deleteCliente() {

        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();
        int id;

        System.out.println("Introduce el id del cliente que deseas eliminar\n");
        id = input.nextInt();
        System.out.println(" ");

        try {
            actualSessions.beginTransaction();
            ClientesPremium cpr = actualSessions.get(ClientesPremium.class, id);

            if (cpr != null) {

                actualSessions.delete(cpr);
                actualSessions.getTransaction().commit();
                System.out.println("registro eliminado.");
            } else if (cpr == null) {
                actualSessions.close();

                ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
                ClientesEstandar ces= actualSessions.get(ClientesEstandar.class, id);
                actualSessions = ormSessions.openSession();
                actualSessions.delete(ces);
                actualSessions.getTransaction().commit();
                System.out.println("registro eliminado.");
            }


        } finally {
            actualSessions.close();
        }


    }
}















