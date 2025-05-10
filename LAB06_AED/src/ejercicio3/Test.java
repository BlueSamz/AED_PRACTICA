package ejercicio3;
import actividad1.ExceptionIsEmpty;
import actividad3.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> cola = new PriorityQueueLinked<>(4);

            cola.enqueue("A", 0);
            cola.enqueue("B", 2);
            cola.enqueue("C", 2);
            cola.enqueue("D", 0);
            cola.enqueue("E", 3);
            cola.enqueue("F", 1);

            System.out.println(cola);

            System.out.println("Front: " + cola.front()); 
            System.out.println("Back: " + cola.back());   

            System.out.println("Dequeue: " + cola.dequeue()); 
            System.out.println("Dequeue: " + cola.dequeue()); 

            System.out.println("\nDespués de dos dequeue:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
