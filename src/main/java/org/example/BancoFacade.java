package org.example;

public class BancoFacade {
    private final Banco banco;


    public BancoFacade() {
        banco = Banco.getInstance();
    }

    // Crear cliente mediante Builder
    public Cliente crearCliente(String nombre, String identificacion, String direccion, String telefono) {
        Cliente cliente = new Cliente
                .Builder()
                .nombre(nombre)
                .identificacion(identificacion)
                .direccion(direccion)
                .telefono(telefono)
                .build();
        banco.registrarCliente(cliente);
        return cliente;
    }

    // Abrir cuenta simple (devuelve ICuenta para permitir decoradores)
    public ICuenta abrirCuenta(Cliente propietario,String numeroCuenta) {
        Cuenta cuentaNueva = new Cuenta(propietario, numeroCuenta);
        banco.agregarCuenta(cuentaNueva);
        return cuentaNueva;
    }

    // Abrir cuenta con límite (Decorator)
    public ICuenta abrirCuentaConLimite(Cliente propietario, String numeroCuenta,double limiteSobregiro) {
        ICuenta cuenta = abrirCuenta(propietario, numeroCuenta);
        ICuenta conLimite = new CuentaConLimite(cuenta, limiteSobregiro);
        banco.getCuentas().remove(cuenta);
        banco.getCuentas().add(conLimite);
        return conLimite;
    }


    public void consignar(ICuenta cuenta, double monto) {
        cuenta.consignar(monto);
    }


    public boolean retirar(ICuenta cuenta, double monto) {
        return cuenta.retirar(monto);
    }


}
