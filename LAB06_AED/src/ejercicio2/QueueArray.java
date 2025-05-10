package ejercicio2;
import actividad2.Queue;
import actividad1.ExceptionIsEmpty;
import actividad2.Node;


public class QueueArray<T> implements Queue<T> {
    private T[] data;
    private int first;
    private int last;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) {
            throw new IllegalStateException("Cola llena");
        }
        data[last] = element;
        last = (last + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        T element = data[first];
        data[first] = null; 
        first = (first + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public T front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return data[first];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public T back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        int lastPos = (last - 1 + capacity) % capacity;
        return data[lastPos];
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola: ");
        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity;
            sb.append(data[index]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.toString();
    }


}
