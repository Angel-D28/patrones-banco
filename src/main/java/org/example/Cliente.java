package org.example;

//Builder en cliente
public class Cliente {
    private  final String nombre;
    private  final String identificacion;
    private  final String direccion;
    private  final String telefono;


    private Cliente(Builder builder) {
        this.nombre = builder.nombre;
        this.identificacion = builder.identificacion;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
    }

    public static class Builder {
        private String nombre;
        private String identificacion;
        private String direccion ;
        private String telefono ;


        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder identificacion(String identificacion) {
            this.identificacion = identificacion;
            return this;
        }
        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this; }
        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this; }
        public Cliente build() {
            return new Cliente(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}