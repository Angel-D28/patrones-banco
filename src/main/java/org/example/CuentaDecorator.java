package org.example;

public abstract class CuentaDecorator implements ICuenta {
    protected final ICuenta cuentaDecorada;


    protected CuentaDecorator(ICuenta cuentaDecorada) {
        this.cuentaDecorada = cuentaDecorada;
    }


    @Override
    public void consignar(double monto) {
        cuentaDecorada.consignar(monto);
    }


    @Override
    public boolean retirar(double monto) {
        return cuentaDecorada.retirar(monto);
    }


    @Override
    public double obtenerSaldo() {
        return cuentaDecorada.obtenerSaldo();
    }


    @Override
    public String getDescripcion() {
        return cuentaDecorada.getDescripcion();
    }
}
