package org.example;

public class Cuenta {
    private String numCuenta;
    private Cliente cliente;
    private double saldo;

    public Cuenta(String numCuenta, Cliente cliente) {
        this.numCuenta = numCuenta;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public void  consignar(double saldo) {
        this.saldo += saldo;
    }

    public void retirar(double valor) {

        if (saldo >= valor) {
            this.saldo -= valor;
        }
        else{
            System.out.println("Fondos insuficientes");
        }
    }

    public void transferir(Cuenta destino, double valor) {

        if(this.saldo >= valor) {
            destino.consignar(valor);
            this.retirar(valor);
        }
        else{
            System.out.println("Fondos insuficientes para esta transferencia");
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return numCuenta + "\t" + cliente.toString() +  "\t" + saldo;
    }
}
