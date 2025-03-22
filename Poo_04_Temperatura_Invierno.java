package poo_04_temperatura_invierno;

import java.util.Random;

public class Poo_04_Temperatura_Invierno {
    public static void main(String[] args) {
        Invernadero invernadero = new Invernadero(); // Crear objeto de la clase Invernadero
        
        System.out.println("Iniciando monitoreo del invernadero. Presiona Ctrl+C para detener.");
        
        while (true) { // Bucle infinito hasta que el usuario lo detenga manualmente
            double temperatura = invernadero.leerTemperatura(); // Obtener temperatura simulada
            String estado = invernadero.controlarClima(temperatura);
            
            System.out.println("Temperatura actual: " + temperatura + "°C - " + estado);
            
            try {
                Thread.sleep(5000); // Esperar 5 segundos antes de la siguiente lectura
            } catch (InterruptedException e) {
                System.out.println("Monitoreo interrumpido.");
                break;
            }
        }
    }
}

class Invernadero {
    private Random random = new Random();
    
    public double leerTemperatura() {
        return 5 + random.nextDouble() * 30; // Genera una temperatura entre 5°C y 35°C
    }
    
    public String controlarClima(double temperatura) {
        if (temperatura < 10) {
            return "Calefactor activado.";
        } else if (temperatura > 25) {
            return "Ventilador activado.";
        } else {
            return "Sistema inactivo.";
        }
    }
}
