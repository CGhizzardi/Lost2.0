package Modelo;

/** Clase abstracta "Clientes" */

public abstract class Clientes {

    /** atributos de la clase */

    private String nombre;
    private String domicilio;
    private String nif;
    private String email;
    private double cuota;
    private double descuento;



    /** Metodo constructor de la clase Clientes
     *
     * @param name
     * @param addres
     * @param Nif
     * @param mail
     * @param cuotaMensual
     * @param descuento
     */

    public Clientes(String name, String addres, String Nif, String mail, double cuotaMensual, double descuento){
        this.nombre= name;
        this.domicilio= addres;
        this.nif= Nif;
        this.email= mail;
        this.cuota= cuotaMensual;
        this. descuento= descuento;

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
        this.cuota = cuota;
    }

    public double getCuota() {
        return cuota;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }








    /** Metodo to String para la clase Clientes ClientesEstandar*/

    @Override
    public String toString() {
        return "Nombre del Clientes: " + nombre + "Domicilio: " + domicilio + "Nif del Cliente " + nif + "Correo electronico: " + email;
    }
    /** Metodo to String para la clase Clientes ClientesPremium*/



}
