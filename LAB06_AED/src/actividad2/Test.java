package actividad2;
import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Queue<String> cola = new QueueLink<>();

        try {
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            System.out.println(cola);

            System.out.println("Front: " + cola.front()); 
            System.out.println("Back: " + cola.back());  

            System.out.println("Dequeue: " + cola.dequeue()); 
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        Queue<Integer> colaNumeros = new QueueLink<>();
        try {
            colaNumeros.enqueue(1);
            colaNumeros.enqueue(2);
            colaNumeros.enqueue(3);
            System.out.println(colaNumeros); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

