package Modelo;
import java.text.SimpleDateFormat;
import java.time.*;
import java.text.ParseException;
import java.util.Date;
public class Pedido {

/** Atributos de la clase */


private int numeroPedido;
private Clientes cliente;
private Articulos articulo;
private int cantidadArticulos;
private LocalDateTime fechaHora;
private double precioTotal;
private boolean enviado;


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

    public void setEnviado(boolean enviado) { this.enviado = pedidoEnviado(fechaHora, articulo.getTiempoDePreparacion()); }

    public boolean getEnviado(){ return enviado; }

    public void setPrecioTotal(double precioTotal){ this.precioTotal = precioEnvio(articulo.getPrecioDeVenta(),cantidadArticulos,articulo.getGastosDeEnvio(),cliente.getDescuento()); }

    public double getPrecioTotal() { return precioTotal; }


  public boolean pedidoEnviado(LocalDateTime fechaHora, Long tiempoPreparacion){        // funcion para saber si el pedido ha sido envido o no
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String fecha1=fechaHora.toString().replace("T"," ");  //fecha elaboracion
        String fecha2=LocalDateTime.now().toString().replace("T"," "); //fecha actual
        try {
            Date date1 = sdf.parse(fecha1);
            Date date2 = sdf.parse(fecha2);
            long diff = date2.getTime() - date1.getTime();
            if(diff>tiempoPreparacion){   //si diff es mayor al tiempo de prep., el pedido ya se ha enviado
                return true;
            }else{    //si diff es menor al tiempo de prep., el pedido aun no se ha enviado
                return false;
            }
        }
        catch (ParseException e) {
            System.out.println("El calculo de pedidoEnviado() en pedidos, ha fallado.");
            e.printStackTrace();
        }
        return true;  //si hay algun error, el pedido no se devolvera ya que saldra como enviado.
    }


    /*
    public double precioEnvio(){  //precio de pedido = precio de cada articulo X cantidad + gastos de envio del articulo - descuento(¿¿es % ???)
        if (cliente.getDescuento()!=0){
            return articulo.getPrecioDeVenta()*cantidadArticulos+articulo.getGastosDeEnvio()- cliente.getDescuento();   //tengo que saber como esta "descuento", si es % o no.
        }else{
            return articulo.getPrecioDeVenta() * cantidadArticulos + articulo.getGastosDeEnvio();
        }

    }
    */

//Funcion para calcular el precio TOTAL del pedido (precio de todos los articulos + envio - descuento)
    public double precioEnvio(double precioDeVenta, double cantidadArticulos, double gastosEnvio, double descuento){
        double precio = precioDeVenta*cantidadArticulos;
        if (descuento!=0){
            return precio-(precio*descuento/100)+gastosEnvio;
        }else{
            return precio + gastosEnvio;
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
                ", Descripción=" + articulo.getDescripcion() +    ///DESCRIPCION ARTICULO!!(getDescripcion() no existe en rama principal)
                ", Cantidad=" + cantidadArticulos +
                ", Articulo codigo=" + articulo.getPrecioDeVenta() +
                ", Envio=" + precioEnvio(articulo.getPrecioDeVenta(),cantidadArticulos,articulo.getGastosDeEnvio(),cliente.getDescuento()) +" €"+
                ", Precio total=" + precioTotal + " €"+
                ", El pedido esta enviado=" + enviado +   //falta probar
                '}';
    }
}

