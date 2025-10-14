package org.example;

import java.util.ArrayList;
import java.util.List;

//SINGLETON
public class Banco {
    private static Banco instancia;
    private final List<ICuenta> cuentas;
    private final List<Cliente> clientes;


    private Banco() {
        cuentas = new ArrayList<>();
        clientes = new ArrayList<>();
    }


    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco();
        }
        return instancia;
    }


    public void registrarCliente(Cliente cliente) { clientes.add(cliente); }
    public void agregarCuenta(ICuenta cuenta) { cuentas.add(cuenta); }


    public List<ICuenta> getCuentas() { return cuentas; }
    public List<Cliente> getClientes() { return clientes; }
}