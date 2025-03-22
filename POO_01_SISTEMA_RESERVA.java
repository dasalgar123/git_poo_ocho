package Poo_01_GestionReserva;

import java.util.Scanner;

// Clase que representa una sala con asientos reservables
class Sala {
    private String[] asientos; // Array que almacena el estado de los asientos

    // Constructor que inicializa la sala con un número específico de asientos
    public Sala(int capacidad) {
        asientos = new String[capacidad]; 
        for (int i = 0; i < capacidad; i++) {
            asientos[i] = "libre"; // Inicialmente todos los asientos están libres
        }
    }

    // Método para reservar un asiento específico
    public boolean reservarAsiento(int numero) {
        if (numero < 0 || numero >= asientos.length) {
            System.out.println("Número de asiento inválido.");
            return false;
        }
        if (asientos[numero].equals("ocupado")) {
            System.out.println("El asiento ya está reservado.");
            return false;
        }
        asientos[numero] = "ocupado";
        System.out.println("Reserva exitosa del asiento " + numero);
        return true;
    }

    // Método que verifica si aún quedan asientos disponibles en la sala
    public boolean hayAsientosDisponibles() {
        for (String asiento : asientos) {
            if (asiento.equals("libre")) { 
                return true;
            }
        }
        return false; 
    }

    // Método que muestra el estado actual de los asientos en la sala
    public void mostrarAsientos() {
        System.out.print("Estado de los asientos: ");
        for (String estado : asientos) {
            System.out.print("[" + estado + "] ");
        }
        System.out.println();
    }
}

// Clase principal que gestiona el sistema de reservas
public class Poo_01_Sistema_Reserva {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sala objSala = new Sala(10); // Creación del objeto Sala

        while (objSala.hayAsientosDisponibles()) {
            objSala.mostrarAsientos();
            System.out.print("Ingrese el número de asiento a reservar (0-9): ");
            int asiento = scanner.nextInt();
            objSala.reservarAsiento(asiento);
        }
        
        System.out.println("La sala está llena. No hay más asientos disponibles.");
        scanner.close();
    }
}
