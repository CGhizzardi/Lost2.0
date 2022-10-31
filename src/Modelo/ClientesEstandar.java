package Modelo;
/** Clase "ClientesEstandar" */

public class ClientesEstandar extends Clientes {

    /**
     * Metodo constructor de la clase
     *
     * @param name
     * @param addres
     * @param Nif
     * @param mail
     */

    //cONSTRUCTOR 1
    public ClientesEstandar(String name, String addres, String Nif, String mail) {
        super(name, addres, Nif, mail);
    }

    //TO STRING
    @Override
    public Clientes copiaCliente(Clientes clientes) {
        return null;
    }

    @Override
    public String tipoCliente() {
        return null;
    }

    @Override
    public float calcAnual() {
        return 0;
    }

    @Override
    public float descuentoEnv() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    public Clientes copiaCliente(ClientesEstandar clientes){
        ClientesEstandar e = (ClientesEstandar) clientes;
        Clientes copiaCliente = new ClientesEstandar(e.getNombre(), e.getDomicilio(),e.getNif(), e.getEmail());
        return copiaCliente(e);
    }
    public String imtipoCliente(){
        return "El cliente " + this.getNombre() + "es de tipo Estandar";
    }
    public float imcalcAnual(){
        return 0;
    }
    public float imdescuentoEnv(){
        return 0;
    }
}