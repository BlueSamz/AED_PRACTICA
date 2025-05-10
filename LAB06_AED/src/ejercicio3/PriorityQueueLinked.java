package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.QueueLink;
import actividad3.PriorityQueue;

public class PriorityQueueLinked<E, N extends Number & Comparable<N>> implements PriorityQueue<E, N>{

    private QueueLink<E>[] colas;
    private int numPrioridades;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int numPrioridades) {
        this.numPrioridades = numPrioridades;
        colas = new QueueLink[numPrioridades];
        for (int i = 0; i < numPrioridades; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E x, N pr) {
        int prioridad = pr.intValue(); 
        if (prioridad < 0 || prioridad >= numPrioridades) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        colas[prioridad].enqueue(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < numPrioridades; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < numPrioridades; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = numPrioridades - 1; i >= 0; i--) {
            if (!colas[i].isEmpty()) {
                return colas[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < numPrioridades; i++) {
            if (!colas[i].isEmpty()) return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola de prioridad enlazada:\n");
        for (int i = 0; i < numPrioridades; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(colas[i].toString()).append("\n");
        }
        return sb.toString();
    }

}
