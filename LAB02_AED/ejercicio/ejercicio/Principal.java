package ejercicio;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Bucle principal para que el usuario siga seleccionando operaciones
        while (true) {
            // Menú de operaciones
            System.out.println("\nMenú de Operaciones:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            if (opcion == 8) {
                System.out.println("Saliendo del programa...");
                break; //Sale del programa
            }

            //Pregunta el tipo de dato (Integer o Double)
            System.out.println("Seleccione el tipo de dato:");
            System.out.println("1. Integer");
            System.out.println("2. Double");
            System.out.print("Ingrese su opción: ");
            int tipoDato = sc.nextInt();

            if (tipoDato != 1 && tipoDato != 2) {
                System.out.println("Opción no válida, intente nuevamente.");
                continue;
            }

            //Dependiendo del tipo de dato seleccionado, se solicita el ingreso de los números
            if (tipoDato == 1) {
                Integer num1 = ingresarNumeroEntero("Ingrese el primer número (Integer): ");
                Integer num2 = ingresarNumeroEntero("Ingrese el segundo número (Integer): ");
                realizarOperacion(opcion, num1, num2); //Llama a la operación con números Integer
            } else {
                Double num1 = ingresarNumeroDouble("Ingrese el primer número (Double): ");
                Double num2 = ingresarNumeroDouble("Ingrese el segundo número (Double): ");
                realizarOperacion(opcion, num1, num2); //llama a la operación con números Double
            }
        }
    }

    // Método para ingresar un número entero con validación
    public static Integer ingresarNumeroEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        Integer numero = null;
        while (numero == null) {
            System.out.print(mensaje);
            try {
                numero = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número entero.");
                sc.next(); 
            }
        }
        return numero;
    }

    // Método para ingresar un número double con validación
    public static Double ingresarNumeroDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        Double numero = null;
        while (numero == null) {
            System.out.print(mensaje);
            try {
                numero = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número de tipo Double.");
                sc.next(); 
            }
        }
        return numero;
    }

    // Método para realizar la operación seleccionada
    public static <T extends Number> void realizarOperacion(int opcion, T num1, T num2) {
        switch (opcion) {
            case 1:
                System.out.println("Resultado de la suma: " + OperacionesMat.suma(num1, num2));
                break;
            case 2:
                System.out.println("Resultado de la resta: " + OperacionesMat.resta(num1, num2));
                break;
            case 3:
                System.out.println("Resultado del producto: " + OperacionesMat.producto(num1, num2));
                break;
            case 4:
                try {
                    System.out.println("Resultado de la división: " + OperacionesMat.division(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.out.println("Resultado de la potencia: " + OperacionesMat.potencia(num1, num2));
                break;
            case 6:
                System.out.println("Resultado de la raíz cuadrada de " + num1 + ": " + OperacionesMat.raizCuadrada(num1));
                break;
            case 7:
                System.out.println("Resultado de la raíz cúbica de " + num1 + ": " + OperacionesMat.raizCubica(num1));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
