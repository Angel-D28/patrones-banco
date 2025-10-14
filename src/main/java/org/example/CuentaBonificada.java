package org.example;

public class CuentaBonificada extends CuentaDecorator {
    private final double porcentajeBonificacion;


    public CuentaBonificada (ICuenta cuentaDecorada, double porcentajeBonificacion) {
        super(cuentaDecorada);
        this.porcentajeBonificacion = porcentajeBonificacion;
    }


    @Override
    public void consignar (double monto) {
        double bonificacion = monto * porcentajeBonificacion;
        super.consignar(monto + bonificacion);
    }


    @Override
    public String getDescripcion() {
        return cuentaDecorada.getDescripcion() + " [Bonificada: " + (porcentajeBonificacion*100) + "%]";
    }
}
