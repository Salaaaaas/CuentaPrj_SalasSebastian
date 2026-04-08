import java.util.Scanner;
import java.util.ArrayList;

public class PrincipalCuenta {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        Cuenta cuentaActual = null;
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DE CUENTAS ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Conocer la cantidad de cuentas creadas");
            System.out.println("3. Listar cuentas");
            System.out.println("4. Seleccionar cuenta actual");
            System.out.println("5. Asignar el nombre del cuenta habiente");
            System.out.println("6. Depositar");
            System.out.println("7. Retirar");
            System.out.println("8. Consultar saldo");
            System.out.println("9. Consultar estado de la cuenta");
            System.out.println("10. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Monto inicial: ");
                    double montoIni = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.print("¿Ingresar nombre ahora? (s/n): ");
                    if (entrada.nextLine().equalsIgnoreCase("s")) {
                        System.out.print("Nombre: ");
                        String nom = entrada.nextLine();
                        listaCuentas.add(new Cuenta(nom, montoIni));
                    } else {
                        listaCuentas.add(new Cuenta(montoIni));
                    }
                    break;

                case 2:
                    System.out.println("Total cuentas: " + Cuenta.getCantCuentasCreadas());
                    break;

                case 3:
                    if (listaCuentas.isEmpty()) {
                        System.out.println("No hay cuentas.");
                    } else {
                        for (int i = 0; i < listaCuentas.size(); i++) {
                            System.out.println("[" + i + "] " + listaCuentas.get(i).toString());
                        }
                    }
                    break;

                case 4:
                    if (listaCuentas.isEmpty()) {
                        System.out.println("Cree una cuenta primero.");
                    } else {
                        System.out.print("Índice de cuenta: ");
                        int idx = entrada.nextInt();
                        if (idx >= 0 && idx < listaCuentas.size()) {
                            cuentaActual = listaCuentas.get(idx);
                            System.out.println("Seleccionada: " + cuentaActual.getCodCuenta());
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;

                case 5:
                    if (cuentaActual != null) {
                        System.out.print("Nuevo nombre: ");
                        cuentaActual.setNombreCuentaHabiente(entrada.nextLine());
                    } else {
                        System.out.println("Seleccione una cuenta (Opción 4).");
                    }
                    break;

                case 6:
                    if (cuentaActual != null) {
                        System.out.print("Monto a depositar: ");
                        double dep = entrada.nextDouble();
                        System.out.println("Saldo final: " + cuentaActual.depositar(dep));
                    } else {
                        System.out.println("Seleccione una cuenta.");
                    }
                    break;

                case 7:
                    if (cuentaActual != null) {
                        System.out.print("Monto a retirar: ");
                        double ret = entrada.nextDouble();
                        System.out.println("Saldo final: " + cuentaActual.retirar(ret));
                    } else {
                        System.out.println("Seleccione una cuenta.");
                    }
                    break;

                case 8:
                    if (cuentaActual != null) {
                        System.out.println("Saldo: " + cuentaActual.getSaldo());
                    } else {
                        System.out.println("Seleccione una cuenta.");
                    }
                    break;

                case 9:
                    if (cuentaActual != null) {
                        System.out.println(cuentaActual.toString());
                    } else {
                        System.out.println("Seleccione una cuenta.");
                    }
                    break;
            }
        } while (opcion != 10);
    }
}