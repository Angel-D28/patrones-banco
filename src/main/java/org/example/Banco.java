package org.example;

import java.util.ArrayList;
import java.util.List;

//SINGLETON 
public class Banco {
    private static Banco instancia;
    private final List<Cuenta> cuentas;
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


    public void registrarCliente(Cliente c) { clientes.add(c); }
    public void agregarCuenta(Cuenta c) { cuentas.add(c); }


    public List<Cuenta> getCuentas() { return cuentas; }
    public List<Cliente> getClientes() { return clientes; }
}