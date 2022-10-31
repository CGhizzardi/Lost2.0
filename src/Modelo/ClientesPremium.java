package Modelo;

/** Clase abstracta "ClientesPremium" */
//CLIENTE PREMIUM
//CUOTA ANUAL - 30€
//20% DE DESCUENTO EN LOS GASTOS DE ENVIO DE CADA PEDIDO.
public class ClientesPremium extends Clientes {


    public ClientesPremium(String name, String Ad, String Nif, String mail, double quota, double desc) {
        super(name, Ad, Nif, mail, quota, desc);
    }

    public ClientesPremium(String name, String Ad, String Nif, String mail) {
        super(name, Ad, Nif, mail);
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setDomicilio(String domicilio) {
        super.setDomicilio(domicilio);
    }

    @Override
    public String getDomicilio() {
        return super.getDomicilio();
    }

    @Override
    public void setNif(String nif) {
        super.setNif(nif);
    }

    @Override
    public String getNif() {
        return super.getNif();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setCuota(double cuota) {
        super.setCuota(cuota);
    }

    @Override
    public double getCuota() {
        return super.getCuota();
    }

    @Override
    public void setDescuento(double descuento) {
        super.setDescuento(descuento);
    }

    @Override
    public double getDescuento() {
        return super.getDescuento();
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






