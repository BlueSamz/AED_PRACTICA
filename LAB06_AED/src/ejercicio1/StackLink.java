package ejercicio1;

import actividad1.ExceptionIsEmpty;
import actividad2.Node;
import actividad1.Stack;

public class StackLink<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public StackLink() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacia");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacia");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila enlazada: ");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
