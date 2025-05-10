package ejercicio2;

import actividad2.Queue;
import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> cola = new QueueArray<>(5);

        try {
            cola.enqueue(10);
            cola.enqueue(20);
            cola.enqueue(30);
            System.out.println(cola); 

            System.out.println("Front: " + cola.front()); 
            System.out.println("Back: " + cola.back());   

            System.out.println("Eliminar: " + cola.dequeue());
            System.out.println("Cola actualizada: " + cola); 

            System.out.println("Agregar a la cola..");
            cola.enqueue(40);
            cola.enqueue(50);
            cola.enqueue(60);
            System.out.println(cola); 

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
