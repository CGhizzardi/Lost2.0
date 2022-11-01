package Controlador;
import Vista.*;
import Modelo.*;
import java.time.*;



    public class ControlPedidos {
        private Pedido modelo;
        private PedidoVista vista;

        public ControlPedidos(Pedido modelo, PedidoVista vista) {
            this.modelo = modelo;
            this.vista = vista;
        }

        public void setNumeroPedido (int numeroPedido) {modelo.setNumeroPedido (numeroPedido);}

        public int getNumeroPedido() {
            return modelo.getNumeroPedido();
        }

        public void setCliente (Clientes cliente) {modelo.setCliente (cliente);}

        public Clientes getCliente() { return modelo.getCliente();}

        public void setArticulo (Articulos articulo) {modelo.setArticulo (articulo);}

        public Articulos getArticulo() { return modelo.getArticulo();}

        public void setCantidadArticulos (int cantidadArticulos) {modelo.setCantidadArticulos (cantidadArticulos);}

        public int getCantidadArticulos() { return modelo.getCantidadArticulos(); }

        public void setFechaHora (LocalDateTime fechaHora) {modelo.setFechaHora (fechaHora);}

        public LocalDateTime getFechaHora() { return modelo.getFechaHora(); }

        public void setPrecioTotal (double precioTotal) {modelo.setPrecioTotal (precioTotal);}

        public double getPrecioTotal() { return modelo.getPrecioTotal(); }

        public void setEnviado (boolean enviado) {modelo.setEnviado (enviado);}

        public boolean getEnviado() { return modelo.getEnviado(); }

        }



