package Vista;
import Controlador.*;

public class PedidoVista {

    public void imprimirPedido (controlPedidos pedido){
        System.out.println("numeroPedido=" + pedido.getNumeroPedido() +
                ", fechaHora=" + pedido.getFechaHora() +
                ", Nif del cliente=" + pedido.getCliente().getNif() +
                ", Nombre del Cliente=" + pedido.getCliente().getNombre() +
                ", Articulo codigo=" + pedido.getArticulo().getCodigo() +
                ", Descripción=" + pedido.getArticulo().getDescripcion() +
                ", Cantidad=" + pedido.getCantidadArticulos() +
                ", Articulo codigo=" + pedido.getArticulo().getPrecioDeVenta() +
                ", Envio=" + pedido.getPrecioTotal() +" €"+
                ", Precio total=" + pedido.getPrecioTotal() + " €"+
                ", El pedido esta enviado=" + pedido.getEnviado() +
                '}');
    }
}
