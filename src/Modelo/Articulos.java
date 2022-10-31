package Modelo;

/** Clase Articulo */


public class Articulos {

    /** Atributos de la clase */
    private String codigo;
    private String Descripcion;
    private double precioDeVenta;
    private double gastosDeEnvio;
    private int tiempoDePreparacion;


    /**Metodo Constructor de la clase Articulo
     *
     * @param codigo
     * @param descripcion
     * @param precioDeVenta
     * @param gastoDeEnvio
     * @param tiempoDePrepararcion
     */

    /** Constructores */

    public Articulos(String codigo, String descripcion, double precioDeVenta, double gastoDeEnvio, int tiempoDePrepar) {
        this.codigo = codigo;
        this.Descripcion = descripcion;
        this.precioDeVenta = precioDeVenta;
        this.gastosDeEnvio = gastoDeEnvio;
        this.tiempoDePreparacion = tiempoDePrepar;
    }

    public Articulos() {
    }



    /**
     * Metodos getters y setters
     */


    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioDeVenta() {
        return this.precioDeVenta;
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public double getGastosDeEnvio() {
        return this.gastosDeEnvio;
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }

    public long getTiempoDePreparacion() {
        return this.tiempoDePreparacion;
    }

    public String getDescripcion() {return this.Descripcion;}

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;}

    /** El metodo toString() */
    public String toString() {
        return "articulos{codigo='" + this.codigo + "', descripcion='" + this.Descripcion + "', precioDeVenta=" + this.precioDeVenta + ", gastosDeEnvio=" + this.gastosDeEnvio + ", tiempoDePreparacion=" + this.tiempoDePreparacion + "}";
    }



    /** Mostrar articulo de prueba articulo */
    public void mostraArticulos (Articulos art){

        art.toString();



    }

}

