package org.example;

//Builder en cliente
public class Cliente {
    private  String nombre;
    private  String identificacion;
    private  String direccion;
    private  String telefono;


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


        public Builder(String nombre, String identificacion, String direccion, String telefono) {
            this.nombre = nombre;
            this.identificacion = identificacion;
            this.direccion = direccion;
            this.telefono = telefono;
        }


        public Builder direccion(String direccion) { this.direccion = direccion; return this; }
        public Builder telefono(String telefono) { this.telefono = telefono; return this; }
        public Cliente build() { return new Cliente(this); }
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