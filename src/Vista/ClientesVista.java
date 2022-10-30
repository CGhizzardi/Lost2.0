package Vista;

import Controlador.*;


public class ClientesVista {

    public void imprimirClientes (ControlClientes clientes){
        System.out.println("Nombre del cliente: " + clientes.getNombre() + "\n" +
                "Dirección: " + clientes.getDomicilio() + "\n" +
                "NIF: " + clientes.getNif() + "\n" +
                "Mail: " + clientes.getEmail() + "\n");
        if(clientes.getDescuento() > 0 ){
            System.out.println("Cliente Premium \n " +
                    "Descuento: " + clientes.getDescuento() + "\n" +
                    "Cuota Anual: " + clientes.getCuota() + "\n");
        }else {
            System.out.println("Cliente estandar \n");
        }
    }

}
/*GESTION DE CLIENTES - EN EL MENU
 * AÑADIR CLIENTE
 * MOSTRAR CLIENTE
 * MOSTRAR CLIENTE PREMIUM
 * MOSTRAR CLIENTE ESTANDAR*/