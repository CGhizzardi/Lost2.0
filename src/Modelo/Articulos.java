package Modelo;

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
        private int tiempoDePreparacion;


        /**Metodo Constructor de la clase Articulo
         *
         * @param codigo
         * @param descripcion
         * @param precioDeVenta
         * @param gastoDeEnvio
         * @param tiempoDePrepar
         */

        public Articulos(String codigo, String descripcion, double precioDeVenta, double gastoDeEnvio, int tiempoDePrepar) {
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.precioDeVenta = precioDeVenta;
            this.gastosDeEnvio = gastoDeEnvio;
            this.tiempoDePreparacion = tiempoDePrepar;

        }
        /** Metodos getters y setters */

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

        public int getTiempoDePreparacion() {
            return tiempoDePreparacion;
        }

        public void setTiempoDePreparacion(int tiempoDePreparacion) {
            this.tiempoDePreparacion = tiempoDePreparacion;
        }
    }