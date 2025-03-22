package poo_03_calculadora1; // Nombre del paquete donde está la clase

import java.util.InputMismatchException; // Para manejar errores cuando el usuario ingresa un dato incorrecto
import java.util.Scanner; // Para leer datos desde el teclado

// Definimos la clase de la calculadora
public class Poo_03_Calculadora1 {
    private double numero1; // Primer número ingresado por el usuario
    private double numero2; // Segundo número ingresado por el usuario

    // Constructor sin parámetros (valores por defecto: 0 y 0)
    public Poo_03_Calculadora1() {
        this.numero1 = 0;
        this.numero2 = 0;
    }

    // Constructor con parámetros (se inicializa con valores dados por el usuario)
    public Poo_03_Calculadora1(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    // Métodos "setter" para cambiar los valores de los números
    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    // Métodos "getter" para obtener los valores de los números
    public double getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    // Método para sumar los dos números
    public double sumar() {
        return this.numero1 + this.numero2;
    }

    // Método para restar los dos números
    public double restar() {
        return this.numero1 - this.numero2;
    }

    // Método para multiplicar los dos números
    public double multiplicar() {
        return this.numero1 * this.numero2;
    }

    // Método para dividir los dos números
    public double dividir() {
        if (this.numero2 == 0) { // Evita la división por cero
            System.out.println("Error: División por cero no permitida.");
            return Double.NaN; // Retorna un valor "No numérico" si la división no es válida
        }
        return this.numero1 / this.numero2;
    }

    // Método principal (aquí empieza a ejecutarse el programa)
    public static void main(String[] args) {
        Scanner IngreseNumeroUno = new Scanner(System.in); // Scanner para leer el primer número
        Scanner IngreseNumeroDos = new Scanner(System.in); // Scanner para leer el segundo número
        
        Poo_03_Calculadora1 calc = new Poo_03_Calculadora1(); // Se crea un objeto de la calculadora
        boolean continuar = true; // Variable para controlar el bucle del menú

        while (continuar) { // Bucle para mostrar el menú hasta que el usuario decida salir
            try {
                // Mostrar el menú de opciones
                System.out.println("\nSeleccione una operación:");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Salir");
                System.out.print("Opción: ");

                int opcion = IngreseNumeroUno.nextInt(); // Leer la opción elegida por el usuario

                // Si la opción es válida, pedimos los dos números
                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingresa el primer número: ");
                    double num1 = IngreseNumeroUno.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    double num2 = IngreseNumeroDos.nextDouble();

                    calc.setNumero1(num1); // Guardamos el primer número en el objeto calculadora
                    calc.setNumero2(num2); // Guardamos el segundo número en el objeto calculadora
                }

                // Ejecutamos la operación seleccionada
                switch (opcion) {
                    case 1:
                        System.out.println("Resultado de la suma: " + calc.sumar());
                        break;
                    case 2:
                        System.out.println("Resultado de la resta: " + calc.restar());
                        break;
                    case 3:
                        System.out.println("Resultado de la multiplicación: " + calc.multiplicar());
                        break;
                    case 4:
                        System.out.println("Resultado de la división: " + calc.dividir());
                        break;
                    case 5:
                        continuar = false; // Cambiamos la variable para salir del bucle
                        System.out.println("Saliendo de la calculadora.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 5.");
                }
            } catch (InputMismatchException e) { // Captura errores cuando el usuario ingresa algo inválido
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número válido.");
                IngreseNumeroUno.next(); // Limpiar la entrada incorrecta para evitar un bucle infinito
            }
        }
        
        IngreseNumeroUno.close(); // Cerramos el Scanner al final del programa
        IngreseNumeroDos.close(); // Cerramos el segundo Scanner
    }
}
