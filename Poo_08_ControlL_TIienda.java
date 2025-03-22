package poo_08_conrol_tienda;

import java.util.Scanner;

public class Poo_08_ControlL_TIienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Control de Acceso a la Tienda ---");
            System.out.print("¿Tiene membresía? (true/false): ");
            boolean tiene_membresia = sc.nextBoolean();

            System.out.print("¿Está dentro del horario de atención? (true/false): ");
            boolean horario_atencion = sc.nextBoolean();

            System.out.print("¿Es empleado? (true/false): ");
            boolean es_empleado = sc.nextBoolean();

            // Lógica de acceso
            if ((tiene_membresia && horario_atencion) || es_empleado) {
                System.out.println("Acceso permitido.");
            } else {
                System.out.println("Acceso denegado.");
            }

            // Preguntar si desea continuar
            System.out.print("¿Desea verificar otro acceso? (true para sí, false para no): ");
            salir = !sc.nextBoolean(); 
        }

        System.out.println("Sistema de control de acceso finalizado.");
        sc.close();
    }
}
