package org.example;

public class CuentaConLimite extends CuentaDecorator {
    private final double limiteSobregiro;


    public CuentaConLimite(ICuenta cuentaDecorada, double limiteSobregiro) {
        super(cuentaDecorada);
        this.limiteSobregiro = limiteSobregiro;
    }


    @Override
    public boolean retirar(double monto) {
        double saldoActual = cuentaDecorada.obtenerSaldo();
        if (monto <= 0)
            return false;
        if (saldoActual + limiteSobregiro >= monto) {
            // si la cuenta decorada es una Cuenta (no siempre), intentamos retirar
            boolean exito = cuentaDecorada.retirar(monto);
            if (!exito) {
                // Si la cuenta decorada no permitió retirar (p. ej. porque chequea saldo estricto),
                // y si es una Cuenta concreta, ajustamos manualmente si es posible.
                if (cuentaDecorada instanceof Cuenta) {
                    Cuenta cuenta = (Cuenta) cuentaDecorada;
                    // permitir sobregiro: restar incluso si va a saldo negativo hasta el limite
                     saldoActual-= monto;
                    return true;
                }
                // Si no es instancia de Cuenta, fallback: intentar de todas formas
                return false;
            }
            return true;
        }
        return false;
    }
}
