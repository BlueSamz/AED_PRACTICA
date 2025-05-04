package lab05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        gestor.agregarTarea(new Tarea("Estudiar AED", 5));
        gestor.agregarTarea(new Tarea("Hacer ejercicios de lista", 4));
        gestor.agregarTarea(new Tarea("Enviar reporte", 3));
        System.out.println(gestor.contieneTarea(new Tarea("Estudiar AED", 5)));


        int opcion;
        do {
            System.out.println("\n===== GESTOR DE TAREAS =====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Mostrar tareas actuales");
            System.out.println("4. Buscar tarea");
            System.out.println("5. Contar tareas");
            System.out.println("6. Tarea de mayor prioridad");
            System.out.println("7. Invertir lista");
            System.out.println("8. Completar tarea");
            System.out.println("9. Mostrar tareas completadas");
            System.out.println("10. Ordenar tareas por prioridad");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Prioridad (número entero): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();
                    gestor.agregarTarea(new Tarea(nombre, prioridad));
                    System.out.println("Tarea agregada!");
                    break;
                case 2:
                    System.out.print("Nombre de la tarea a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Prioridad: ");
                    int prioEliminar = scanner.nextInt();
                    scanner.nextLine();
                    if (gestor.eliminarTarea(new Tarea(nombreEliminar, prioEliminar))) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Tareas actuales:");
                    gestor.imprimirTareas();
                    break;
                case 4:
                    System.out.print("Nombre de la tarea a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    System.out.print("Prioridad: ");
                    int prioBuscar = scanner.nextInt();
                    scanner.nextLine();
                    if (gestor.contieneTarea(new Tarea(nombreBuscar, prioBuscar))) {
                        System.out.println("Tarea encontrada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Total de tareas: " + gestor.contarTareas());
                    break;
                case 6:
                    Tarea masPrioritaria = gestor.obtenerTareaMasPrioritaria();
                    if (masPrioritaria != null) {
                        System.out.println("Tarea con mayor prioridad: " + masPrioritaria);
                    } else {
                        System.out.println("No hay tareas.");
                    }
                    break;
                case 7:
                    gestor.invertirTareas();
                    System.out.println("Tareas invertidas.");
                    break;
                case 8:
                    System.out.print("Nombre de la tarea a completar: ");
                    String nombreCompletar = scanner.nextLine();
                    System.out.print("Prioridad: ");
                    int prioCompletar = scanner.nextInt();
                    scanner.nextLine();
                    gestor.completarTarea(new Tarea(nombreCompletar, prioCompletar));
                    System.out.println("Tarea marcada como completada.");
                    break;
                case 9:
                    System.out.println("Tareas completadas:");
                    gestor.mostrarTareasCompletadas();
                    break;
                case 10:
                    gestor.ordenarTareas();
                    System.out.println("Tareas ordenadas por prioridad.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
