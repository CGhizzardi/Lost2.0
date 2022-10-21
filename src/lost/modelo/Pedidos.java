package lost.modelo;
import java.text.SimpleDateFormat;
import java.time.*;
import java.text.ParseException;
import java.util.Date;
public class Pedidos {



    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    static final int MINUTES_PER_HOUR = 60;
    static final int SECONDS_PER_MINUTE = 60;
    static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!




/** Atributos de la clase */

private int numeroPedido;
private Clientes cliente;
private Articulos articulo;
private int cantidadArticulos;
private LocalDateTime fechaHora;
private double precioTotal;
private boolean enviado;





    /** Metodo Constructor de la clase pedido
     *
     * @param numeroPedido
     * @param cliente
     * @param articulo
     * @param cantidadArticulos
     */

    public Pedidos(int numeroPedido, Clientes cliente, Articulos articulo, int cantidadArticulos) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidadArticulos = cantidadArticulos;
        this.fechaHora= LocalDateTime.now();   //la hora de prodruccion del pedido
    }


    /** Metodos Getters y Setters */


    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {   //entiendo que en el momento de crear el pedido ya calcula la hora de ese momento "this.fechaHora= LocalDateTime.now()";
        this.fechaHora = fechaHora;
    }



  public boolean pedidoEnviado(){        // funcion para saber si el pedido ha sido envido o no
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String fecha1=fechaHora.toString().replace("T"," ");  //fecha elaboracion
        String fecha2=LocalDateTime.now().toString().replace("T"," "); //fecha actual
        try {
            Date date1 = sdf.parse(fecha1);
            Date date2 = sdf.parse(fecha2);
            long diff = date2.getTime() - date1.getTime();
            if(diff>articulo.getTiempoDePreparacion()){   //si diff es mayor al tiempo de prep., el pedido ya se ha enviado
                return true;
            }else{    //si diff es menor al tiempo de prep., el pedido aun no se ha enviado
                return false;
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    //Para calcular el precio del pedido hay que tener en cuenta el precio de venta, las unidades pedidas, el coste del envío y si el cliente que lo ha realizado es premium.
    public double precioEnvio(){
        if (cliente.getDescuento()!=0){    //REPASAR<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            return articulo.getPrecioDeVenta()*cantidadArticulos+articulo.getGastosDeEnvio()- cliente.getDescuento();
        }else{
            return articulo.getPrecioDeVenta() * cantidadArticulos + articulo.getGastosDeEnvio();
        }

    }


    @Override
    public String toString() {
        return "Pedidos{" +
                "numeroPedido=" + numeroPedido +
                ", fechaHora=" + fechaHora +
                ", Nif del cliente=" + cliente.getNif() +
                ", Nombre del Cliente=" + cliente.getNombre() +
                ", Articulo codigo=" + articulo.getCodigo() +
                ", Descripción=" + articulo +    ///DESCRIPCION ARTICULO!! no existe aun
                ", Cantidad=" + cantidadArticulos +
                ", Articulo codigo=" + articulo.getPrecioDeVenta() +
                ", Envio=" + precioEnvio() +" €"+
                ", Precio total=" + precioTotal + " €"+
                ", El pedido esta enviado=" + enviado +   //falta calcularlo!!!!
                '}';
    }
}
