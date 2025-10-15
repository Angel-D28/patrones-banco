package org.example;

public class Cuenta implements ICuenta{
    private String numeroCuenta;
    private final Cliente propietario;
    private double saldo;


    public Cuenta(Cliente propietario, String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = 0;
    }



    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public Cliente getPropietario() {
        return propietario;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void consignar(double monto) {
        if (monto <= 0) return;
        saldo += monto;
    }


    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) return false;
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }


    @Override
    public double obtenerSaldo() {
        return saldo;
    }


    @Override
    public String getDescripcion() {
        return "Cuenta #" + numeroCuenta + " de " + propietario.getNombre();
    }


    @Override
    public String toString() {
        return getDescripcion() + " - Saldo: " + saldo;
    }
}