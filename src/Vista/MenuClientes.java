package Vista;

import Controlador.Controller;
import Modelo.Clientes;
import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;
/*GESTION DE CLIENTES - EN EL MENU
 * AÑADIR CLIENTE
 * MOSTRAR CLIENTE
 * MOSTRAR CLIENTE PREMIUM
 * MOSTRAR CLIENTE ESTANDAR*/

public class MenuClientes {
    Controller controller;

    public MenuClientes(){
        this.controller=new Controller();
    }

    //addCliente();
    public void addCliente(){



    }

    //mostrarCliente();
    public Clientes mostrarCliente(){

        controller.mostrarCli();

        return null;
    }

    //mostrarClPremium();
    public ClientesPremium mostrarClPremium(){


        return null;
    }

    //mostrarClEstandar();
    public ClientesEstandar mostrarClEstandar(){

        return null;
    }

}