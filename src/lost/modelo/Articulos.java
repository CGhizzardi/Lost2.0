package lost.modelo;

/** Clase Articulo */

import java.sql.Time;
import java.util.Date;

    public class Articulos {

        /**
         * Atributos de la clase
         */

        private String codigo;
        private String descripcion;
        private double precioDeVenta;
        private double gastosDeEnvio;
        private long tiempoDePreparacion;


        public Articulos(String codigo, String descripcion, double precioDeVenta, double gastoDeEnvio, int tiempoDePrepar) {
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.precioDeVenta = precioDeVenta;
            this.gastosDeEnvio = gastoDeEnvio;
            this.tiempoDePreparacion = tiempoDePrepar;

        }

        /**
         * Metodos getters y setters
         */

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public double getPrecioDeVenta() {
            return precioDeVenta;
        }

        public void setPrecioDeVenta(double precioDeVenta) {
            this.precioDeVenta = precioDeVenta;
        }

        public double getGastosDeEnvio() {
            return gastosDeEnvio;
        }

        public void setGastosDeEnvio(double gastosDeEnvio) {
            this.gastosDeEnvio = gastosDeEnvio;
        }

        public long getTiempoDePreparacion() {
            return tiempoDePreparacion;
        }

        public void setTiempoDePreparacion(long tiempoDePreparacion) {
            this.tiempoDePreparacion = tiempoDePreparacion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() { return descripcion; }

    }
