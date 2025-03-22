package poo_07_aireacondicionado;

import java.util.Scanner;

public class Poo_07_Aire_Acondicionado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AireAcondicionado aire = new AireAcondicionado(); // Crear objeto de la clase
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese la temperatura actual (°C): ");
            double temperatura = sc.nextDouble();
            System.out.print("Ingrese la humedad actual (%): ");
            double humedad = sc.nextDouble();
            
            // Controlar el aire acondicionado
            System.out.println(aire.controlarAire(temperatura, humedad));
            
            // Preguntar si quiere continuar
            System.out.print("¿Desea seguir monitoreando? (s/n): ");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
        
        sc.close();
        System.out.println("Sistema apagado.");
    }
}

class AireAcondicionado {
    public String controlarAire(double temperatura, double humedad) {
        if ((temperatura > 28 && humedad > 60) || temperatura > 30) {
            return "Aire acondicionado ENCENDIDO.";
        } else {
            return "Aire acondicionado APAGADO.";
        }
    }
}
