package Modelo;

import java.time.*;
import java.time.format.*;

public class Pedidos {

/** Atributos de la clase */

private int numeroPedido;
private Clientes cliente;
private Articulos articulo;
private int cantidadArticulos;
private LocalDateTime fechaHora;


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
        this.fechaHora= LocalDateTime.now();
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

    public void setFechaHora(LocalDateTime fechaHora) {
        fechaHora= LocalDateTime.now();
        this.fechaHora = fechaHora;
    }



    @Override
    public String toString() {
        return "Pedidos{" +
                "numeroPedido=" + numeroPedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                ", cantidadArticulos=" + cantidadArticulos +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
