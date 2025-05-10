package actividad3;

import actividad1.ExceptionIsEmpty;


public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

        try {
            pq.enqueue("Tarea A", 3);
            pq.enqueue("Tarea B", 5);
            pq.enqueue("Tarea C", 1);
            pq.enqueue("Tarea D", 4);

            System.out.println("Cola actual:");
            System.out.println(pq);

            System.out.println("Front (mayor prioridad): " + pq.front());
            System.out.println("Back (menor prioridad): " + pq.back());

            System.out.println("\nEliminando elemento con mayor prioridad: " + pq.dequeue());
            System.out.println("Cola actual:");
            System.out.println(pq);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
