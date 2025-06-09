package Stack;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    @SuppressWarnings("unchecked")
    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
    }

    @Override
    public void push(E x) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        array[++tope] = x;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
        return array[tope--];
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
        return array[tope];
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == array.length - 1;
    }

    @Override
    public int size() {
        return tope + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack [Top -> Bottom]: ");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) sb.append(", ");
        }
        return sb.toString();
    }
}
