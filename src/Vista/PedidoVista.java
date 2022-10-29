package Vista;
import Controlador.*;

public class PedidoVista {

    //public void printPedido (Object pedido) {
    //    System.out.println(pedido.toString());
    //}

    // tal y como esta en el ejemplo:
    public void imprimirPedido (controlPedidos pedido){

        //faltan los datos de cliente y articulo en controlador.

        System.out.println("numeroPedido=" + pedido.getNumeroPedido()+"\n"+
                ", fechaHora=" + pedido.getFechaHora()+"\n" +
                ", Nif del cliente=" + pedido.getCliente().getNif()+"\n" +
                ", Nombre del Cliente=" + pedido.getCliente().getNombre()+"\n" +
                ", Articulo codigo=" + pedido.getArticulo().getCodigo()+"\n" +
                ", Descripción=" + pedido.getArticulo().getDescripcion()+"\n" +
                ", Cantidad=" + pedido.getCantidadArticulos()+"\n" +
                ", Articulo codigo=" + pedido.getArticulo().getPrecioDeVenta()+"\n" +
                ", Envio=" + pedido.getPrecioTotal() +" €\n"+
                ", Precio total=" + pedido.getPrecioTotal() + " €\n"+
                ", El pedido esta enviado=" + pedido.getEnviado()+"\n" +
                '}');
    }
}
