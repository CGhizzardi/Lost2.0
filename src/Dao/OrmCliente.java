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

    public void ormMenuDeleteCliente(){ /**Metodo que contiene el menu de borrar clientes */
    boolean salir = false;
    char opcio;

    ClientesEstandar est;
    ClientesPremium premium;
    System.out.println("Los clientes Estandar son los que no pagan una cuota mensual y los Premium son aquellos que si");
    System.out.println("Que tipo de cliente desea eliminar?");

        do {
        System.out.println("1. Eliminar un Cliente Estandar");
        System.out.println("2. Eliminar un Cliente Premium");
        System.out.println("0. Salir");
        opcio = pedirOpcion();
        switch (opcio) {
            case '1':
                ormDeleteClienteEstandar();
                break;
            case '2':
                ormDeleteClientePremium();
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


    public void ormDeleteClientePremium() {   /** Metodo que borra un cliente Premium seleccionado con el nif */

        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();
        int id;

        System.out.println("Introduce el id del cliente que deseas eliminar\n");
        id = input.nextInt();
        System.out.println(" ");

        try {
            actualSessions.beginTransaction();
            ClientesPremium cpr = actualSessions.get(ClientesPremium.class, id);
             actualSessions.delete(cpr);
             actualSessions.getTransaction().commit();
             System.out.println("registro eliminado.");

        } finally {
            actualSessions.close();
        }
    }

    public void ormDeleteClienteEstandar() {   /** Metodo que borra un cliente Premium seleccionado con el nif */

        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();
        int id;

        System.out.println("Introduce el id del cliente que deseas eliminar\n");
        id = input.nextInt();
        System.out.println(" ");

        try {
            actualSessions.beginTransaction();
            ClientesEstandar cpr = actualSessions.get(ClientesEstandar.class, id);
            actualSessions.delete(cpr);
            actualSessions.getTransaction().commit();
            System.out.println("registro eliminado.");

        } finally {
            actualSessions.close();
        }
    }

    public ClientesEstandar ormObtenerCE(String user, String pass) {  /** Metodo que extrae y guarda un cliente de la base de datos */
        OrmCliente c = new OrmCliente(user, pass);
        ClientesEstandar ce;
        int idc;
        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesEstandar.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();

        c.ormImprimirClientesEstandar();
        System.out.println("Selecciona el id cliente\n");
        idc = input.nextInt();

        try {
            actualSessions.beginTransaction();
            ce = actualSessions.get(ClientesEstandar.class, idc);
            actualSessions.getTransaction().commit();
        } finally {
            actualSessions.close();
        }
        return ce;
    }

    public ClientesPremium ormObtenerPR(String user, String pass) {  /** Metodo que extrae y guarda un cliente de la base de datos */
        OrmCliente c = new OrmCliente(user, pass);
        ClientesPremium pr;
        int idc;
        SessionFactory ormSessions = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ClientesPremium.class).buildSessionFactory();
        Session actualSessions = ormSessions.openSession();

        c.ormImprimirClientesPremium();
        System.out.println("Selecciona el id cliente\n");
        idc = input.nextInt();

        try {
            actualSessions.beginTransaction();
            pr = actualSessions.get(ClientesPremium.class, idc);
            actualSessions.getTransaction().commit();
        } finally {
            actualSessions.close();
        }
        return pr;
    }

        public String nifClienteES(ClientesEstandar x) { /** Metodo que extrae el nif de un cliente */
            String nif;
            nif = x.getNif();
            return nif;
        }

        public String nifClientePR(ClientesPremium x) { /** Metodo que extrae el nif de un cliente */
        String nif;
        nif = x.getNif();
        return nif;
    }

    public String crearClientePedido(String user, String pass) {
        boolean salir = false;
        char opcio;

        ClientesEstandar est;
        ClientesPremium premium;
        int idc;
        String nif = null;
        do {
            System.out.println("1. Añadir Clientes Estandar");
            System.out.println("2. Añadir Clientes Premium");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    est = crearCliE();
                    insClienteEs(est);
                    nif=nifClienteES(est);
                    salir = true;
                    break;
                case '2':
                    premium = crearCliP();
                    insClientePr(premium);
                    nif=nifClientePR(premium);
                    salir = true;
                    break;
            }
        } while (!salir);

        return nif;
    }




    }






















