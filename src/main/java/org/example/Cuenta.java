package org.example;

import java.security.SecureRandom;
import java.util.UUID;

public class Cuenta implements ICuenta{
    private String numeroCuenta;
    private final Cliente propietario;
    private double saldo;


    public Cuenta(Cliente propietario) {
        this.numeroCuenta = generarNumeroCuenta(7);
        this.propietario = propietario;
        this.saldo = 0;
    }

    private static final SecureRandom rnd = new SecureRandom();

    public static String generarNumeroCuenta(int digits) {
        if (digits <= 0) throw new IllegalArgumentException("digits inválido");
        StringBuilder sb = new StringBuilder(digits);
        for (int i = 0; i < digits; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
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