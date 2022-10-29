/**package Controlador;
import junit.framework.TestCase;
import Modelo.*;
import Vista.*;

public class Test_jUnit extends TestCase{
    private Pedido pedido;

    public void escenario (){  pedido = new Pedido(); }
    public void testPrecioEnvio(){  //precio de pedido = precio de cada articulo X cantidad + gastos de envio del articulo - descuento(¿¿es % ???)
        escenario();
        assertTrue(pedido.precioEnvio(10,50,5,0)== 505);

    }
} */
