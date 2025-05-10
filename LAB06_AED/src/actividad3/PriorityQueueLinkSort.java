package actividad3;

import actividad1.ExceptionIsEmpty;
import actividad2.Node;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        public String toString() {
            return "(" + data + ", " + priority + ")";
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            first = last = newNode;
        } else if (pr.compareTo(first.getData().priority) > 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node<EntryNode> current = first;
            while (current.getNext() != null &&
                   pr.compareTo(current.getNext().getData().priority) <= 0) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);

            if (newNode.getNext() == null) {
                last = newNode;
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cannot remove from an empty queue");
        }

        E aux = first.getData().data;
        first = first.getNext();

        if (first == null) {
            last = null;
        }

        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }
        return first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }
        return last.getData().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> current = first;

        while (current != null) {
            sb.append(current.getData().toString()).append(" -> ");
            current = current.getNext();
        }

        sb.append("null");
        return sb.toString();
    }
}
