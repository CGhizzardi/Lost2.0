package Modelo;

/** Clase abstracta "ClientesPremium" */
//CLIENTE PREMIUM
//CUOTA ANUAL - 30€
//20% DE DESCUENTO EN LOS GASTOS DE ENVIO DE CADA PEDIDO.
public class ClientesPremium extends Clientes {


    public ClientesPremium(String name, String Ad, String Nif, String mail, double quota, double desc) {
        super(name, Ad, Nif, mail, quota, desc);
    }

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
        return super.toString() + ", Cuota anual: " + calcAnual()+ ", Descuento en los gastos de envio: " + descuentoEnv();
    }


    //MÉTODOS ABSTRACTOS
    public Clientes copiaCliente(Clientes clientes){
        ClientesPremium e = (ClientesPremium) clientes;
        Clientes copiaCliente = new ClientesPremium(e.getNombre(), e.getDomicilio(), e.getNif(),e.getEmail(), e.getCuota(), e.getDescuento());
        return copiaCliente(e);
    }
    public String tipoCliente(){
        return "El cliente " + this.getNombre() + "es de tipo Premium";
    }
    public float calcAnual(){
        return 30;
    }
    public float descuentoEnv(){
        return (float)0.2;
    }
}






