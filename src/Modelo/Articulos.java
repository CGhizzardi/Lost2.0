package Modelo;

/** Clase Articulo */


public class Articulos {

    /** Atributos de la clase */
    private String codigo;
    private String Descripcion;
    private double precioDeVenta;
    private double gastosDeEnvio;
    private long tiempoDePreparacion;


    /**Metodo Constructor de la clase Articulo
     *
     * @param codigo
     * @param descripcion
     * @param precioDeVenta
     * @param gastoDeEnvio
     * @param tiempoDePrepararcion
     */

    /** Constructores */

    public Articulos(String codigo, String descripcion, double precioDeVenta, double gastoDeEnvio, long tiempoDePrepar) {
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

    public void setTiempoDePreparacion(long tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;}

    /** El metodo toString() */
    public String toString() {
        return "articulos{codigo='" + this.codigo + "', descripcion='" + this.Descripcion + "', precioDeVenta=" + this.precioDeVenta + ", gastosDeEnvio=" + this.gastosDeEnvio + ", tiempoDePreparacion=" + this.tiempoDePreparacion + "}";
    }

    /** Metodos */
    /** Añadir articulo */
    /** En el caso de que el cliente añada el producto habria que cambiar el valor por el Scanner
     * y que lo pueda introducir
     * @param art
     */
    public void addArticulo (Articulos art){
        String cod , desc;
        long tiempo;
        double gastos, precio;
        cod = "asrj";
        desc = "articulo  de prueba";
        tiempo = 12;
        gastos = 13.8;
        precio = 15.8;
        art.setCodigo(cod);
        art.setDescripcion(desc);
        art.setTiempoDePreparacion(tiempo);
        art.setGastosDeEnvio(gastos);
        art.setPrecioDeVenta(precio);
    }
    /** Mostrar articulo de prueba articulo */
    public void mostraArticulos (Articulos art){

        art.toString();



    }

}

