package Modelo;

/** Clase abstracta "Clientes" */

public abstract class Clientes {

    /** atributos de la clase */

    private String nombre;
    private String domicilio;
    private String nif;
    private String email;

    private double cuotaMensual;
    private double descuento;




    /** Metodo constructor de la clase Clientes
     *
     * @param name
     * @param Ad
     * @param Nif
     * @param mail
     *
     */

    public Clientes(String name, String Ad, String Nif, String mail) {
        this.nombre= name;
        this.domicilio= Ad;
        this.nif= Nif;
        this.email= mail;
    }

    /** Metodo constructor con sobrecarga */
    public Clientes(String name, String Ad, String Nif, String mail, double quota, double desc) {
        this.nombre= name;
        this.domicilio= Ad;
        this.nif= Nif;
        this.email= mail;
        this.cuotaMensual = quota;
        this.descuento = desc;
    }


    /** Metodos Getter y setters de la clase */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCuota(double cuota) {
        this.cuotaMensual = cuota;
    }

    public double getCuota() {
        return cuotaMensual;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    //MÉTODOS ABSTRACTOS
    public abstract Clientes copiaCliente (Clientes clientes);
    public abstract String tipoCliente();
    public abstract float calcAnual();
    public abstract float descuentoEnv();

    //TO STRING

    @Override
    public String toString() {
        return "Nombre del Clientes: " + nombre + "Domicilio: " + domicilio + "Nif del Cliente " + nif + "Correo electronico: " + email;
    }




}