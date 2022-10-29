/**package Controlador;
import junit.framework.TestCase;
import Modelo.*;
import Vista.*;
import org.junit.Test;

import java.time.LocalDateTime;

public class Test_jUnit extends TestCase{
    private Pedido pedido;

    public void escenario (){  pedido = new Pedido(); }
    @Test
    public void testPrecioEnvio(){  //precio de pedido = precio de cada articulo X cantidad + gastos de envio del articulo - descuento(¿¿es % ???)
        escenario();
        double precioDeVenta= 10;
        double cantidadArticulos = 50;
        double gastosEnvio = 5;
        double descuento= 0;
        double resultado= 505;
        assertTrue("Calculo no exitoso (PrecioEnvio)",pedido.precioEnvio(precioDeVenta,cantidadArticulos,gastosEnvio,descuento)== resultado);
        System.out.println("La funcion(PrecioEnvio) funciona porque el calculo realizado es correcto.");
    }

    @Test
    public void testPedidoEnviado(){ //se esta introduciendo la fecha y hora de ahora en la creacion del pedido (no deberia constar como enviado)
        escenario();
        long duracionPreparacion= 12;
        LocalDateTime FechaPedido = LocalDateTime.now();
        assertFalse("FALLO: El pedido consta enviado pero no ha superado el tiempo de preparacion.",pedido.pedidoEnviado(FechaPedido,duracionPreparacion));
        System.out.println("La funcion(pedidoEnviado) funciona porque no se ha enviado el pedido todabia.");
    }
} */
