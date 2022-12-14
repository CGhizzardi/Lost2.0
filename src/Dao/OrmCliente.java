package Dao;

import Modelo.Clientes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class OrmCliente {

Scanner input= new Scanner(System.in);

    public OrmCliente(String user, String pass) {

    }

    public Clientes crearCliP(){   // metodo que crea un cliente premium
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

        Clientes cp = new Clientes(nif,nombre,domicilio, email, cuotaMensual,descuento);

        return cp;
    }


     public void insClientePr(Clientes c){
         SessionFactory ormSession= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();

         Session actualSession= ormSession.openSession();


        try {

            actualSession.beginTransaction();
            actualSession.save(c);
            actualSession.getTransaction().commit();
            System.out.println("Cliente premium guardado");

        } finally {
            actualSession.close();

        }



     }

















}
