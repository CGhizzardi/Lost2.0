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
    public String toString() {
        return super.toString();
    }

    //IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    public Clientes copiaCliente(Clientes clientes){
        ClientesEstandar e = (ClientesEstandar) clientes;
        Clientes copiaCliente = new ClientesEstandar(e.getNombre(), e.getDomicilio(),e.getNif(), e.getEmail());
        return copiaCliente(e);
    }
    public String tipoCliente(){
        return "El cliente " + this.getNombre() + "es de tipo Estandar";
    }
    public float calcAnual(){
        return 0;
    }
    public float descuentoEnv(){
        return 0;
    }
}