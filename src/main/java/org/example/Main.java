package org.example;



public class Main {

    public static void main(String[] args) {
        // Crear cliente usando el builder
        Cliente cliente1 = new Cliente.Builder()
                .nombre("Ana Gómez")
                .identificacion("01020203")
                .direccion("Calle 123")
                .telefono("3159876543")
                .build();

        // Crear una cuenta y asociar al cliente
        ICuenta cuenta1 = new Cuenta(cliente1, "ABC123");

        // Mostrar saldo inicial
        System.out.println("Saldo inicial cuenta: " + cuenta1.obtenerSaldo() +"\t"+ cuenta1.getDescripcion());

        Prestamo prestamo = new Prestamo("P001", cuenta1, 1000);
        System.out.println("\nTras otorgar préstamo:");
        System.out.println("Saldo cuenta: " + cuenta1.obtenerSaldo());
        System.out.println("Deuda préstamo: " + prestamo.getDeuda());

        // Hacer un abono parcial
        prestamo.abonar(200);
        System.out.println("\nTras abonar 200:");
        System.out.println("Saldo cuenta: " + cuenta1.obtenerSaldo());
        System.out.println("Deuda préstamo: " + prestamo.getDeuda());

        // Hacer un abono total (superior a la deuda restante)
        prestamo.abonar(900);
        System.out.println("\nTras abonar otros 900 (queda sobrante):");
        System.out.println("Saldo cuenta: " + cuenta1.obtenerSaldo());
        System.out.println("Deuda préstamo: " + prestamo.getDeuda());

        // Resumen final
        System.out.println("\nResumen objeto préstamo:");
        System.out.println(prestamo);
    }
}