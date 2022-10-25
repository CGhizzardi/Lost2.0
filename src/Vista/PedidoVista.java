package Vista;
import Controlador.*;


public class PedidoVista {


    //public void printPedido (Object pedido) {
    //    System.out.println(pedido.toString());
    //}




    // tal y como esta en el ejemplo:
    public void imprimirPedido (controlPedidos pedido, controlClientes cliente, controlArticulos articulo){


        //faltan los datos de cliente y articulo en controlador.

        System.out.println("numeroPedido=" + pedido.getNumeroPedido() +
                ", fechaHora=" + pedido.getFechaHora() +
                ", Nif del cliente=" + cliente.getNif() +
                ", Nombre del Cliente=" + cliente.getNombre() +
                ", Articulo codigo=" + articulo.getCodigo() +
                ", Descripción=" + articulo.getDescripcion() +
                ", Cantidad=" + cantidadArticulos +
                ", Articulo codigo=" + articulo.getPrecioDeVenta() +
                ", Envio=" + pedido.getPrecioTotal() +" €"+
                ", Precio total=" + pedido.getPrecioTotal() + " €"+
                ", El pedido esta enviado=" + pedido.getEnviado() +  
                '}');
    }
}
