package poo_05_detencion_movimiento;

import java.util.Random;
import java.util.Scanner;

public class Poo_05_Detencion_Movimiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Seguridad seguridad = new Seguridad(); // Crear objeto de la clase Seguridad
        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("\nMenú de Seguridad:");
            System.out.println("1. Activar simulación de sensores");
            System.out.println("2. Desactivar alarma");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    seguridad.verificarSensores();
                    break;
                case 2:
                    seguridad.desactivarAlarma();
                    break;
                case 3:
                    ejecutar = false;
                    System.out.println("Saliendo del sistema de seguridad.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
        sc.close();
    }
}

class Seguridad {
    private boolean alarmaActivada;
    private Random random;

    public Seguridad() {
        this.alarmaActivada = false;
        this.random = new Random();
    }

    public void verificarSensores() {
        boolean sensor1 = random.nextBoolean();
        boolean sensor2 = random.nextBoolean();
        boolean sensor3 = random.nextBoolean();
        boolean esDeNoche = random.nextBoolean();
        
        int sensoresDetectando = (sensor1 ? 1 : 0) + (sensor2 ? 1 : 0) + (sensor3 ? 1 : 0);
        
        if (sensoresDetectando >= 2 && esDeNoche) {
            alarmaActivada = true;
            System.out.println("¡Alarma activada! Se detectó movimiento en al menos dos sensores durante la noche.");
        } else {
            System.out.println("Todo en orden. No hay suficiente movimiento o no es de noche.");
        }
    }

    public void desactivarAlarma() {
        if (alarmaActivada) {
            alarmaActivada = false;
            System.out.println("Alarma desactivada.");
        } else {
            System.out.println("La alarma ya está desactivada.");
        }
    }
}
