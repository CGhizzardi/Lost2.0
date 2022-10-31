package Vista;

import Controlador.controller;
import Modelo.Clientes;
import Modelo.ClientesEstandar;
import Modelo.ClientesPremium;
import Controlador.controller.*;
/*GESTION DE CLIENTES - EN EL MENU
 * AÑADIR CLIENTE
 * MOSTRAR CLIENTE
 * MOSTRAR CLIENTE PREMIUM
 * MOSTRAR CLIENTE ESTANDAR*/

public class MenuClientes {
    controller controller;

    public MenuClientes(){
        this.controller=new controller();
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