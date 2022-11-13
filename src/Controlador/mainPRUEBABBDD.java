package Controlador;

import java.sql.Connection;
import java.util.Scanner;
import Modelo.*;
import Dao.*;
public class mainPRUEBABBDD {
    static Entidad e = new Entidad();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el usuario de la bbdd: ");      //pedimos usuario y contraseña para entrar en LOCAL
        String user = input.nextLine();
        System.out.println("Introduce el pasword de la bbdd: ");
        String pass = input.nextLine();
        try {
            System.out.println("1º Conectados con la base de datos...\n");
            Connection c =e.conectarBBDD(user,pass);
            ArticulosDAO dao = new ArticulosDAO(c);
            //ClientesFactory dao2 = new ClientesDAO(c);
            String codigo= "AA2";
            String codigo2= "AA1";
            String descripcion = "Articulo1";
            String descripcion2 = "Articulo2";
            double precioVenta = 5.0;
            double gastosEnvio = 6.0;
            int tiempoPreparacion = 100;

            System.out.println("2º creamos dos articulos automaticamente y los mandamos a la BBDD...\n");
            Articulos a = new Articulos (codigo,descripcion,precioVenta,gastosEnvio,tiempoPreparacion);    //creamos 2 articulos
            Articulos b = new Articulos (codigo2,descripcion2,precioVenta,gastosEnvio,tiempoPreparacion);

            dao.insertarArticulo(a);                                                                        //los añadimos a la BBDD
            dao.insertarArticulo(b);

            System.out.println("3º Vemos todos los articulos de la BBDD:\n");                                             //imprimimos todos los articulos de la BBDD
            System.out.println(dao.obtenerArticulos());

            System.out.println("4º Se eliminan los 2 articulos creados...\n");
            dao.eliminarArticulo(codigo);
            dao.eliminarArticulo(codigo2);

            System.out.println("5º Finalmente se comprueva que la lista de Articulos vuelve a estar vacia:\n");                                             //imprimimos todos los articulos de la BBDD
            System.out.println(dao.obtenerArticulos());
/*
            System.out.println("6º crenado clientes : \n");
            String nif = "39432319Y";
            String nombre = "Pepe";
            String domicilio= "Barcelona";
            String email = "ggggg@gmail.com";
            double cuotaMensual= 5.0;
            double descuento =6.0;

            ClientesPremium cP = new ClientesPremium(nif,nombre,domicilio,email,cuotaMensual, descuento);
            dao2.insertarCliente(cP);

*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
