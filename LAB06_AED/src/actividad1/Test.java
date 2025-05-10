package actividad1;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pila = new StackArray<>(5);
        try {
            pila.push(10);
            pila.push(20);
            pila.push(30);
            System.out.println(pila);  
            System.out.println("Top: " + pila.top()); 
            System.out.println("Pop: " + pila.pop());
            System.out.println(pila);  
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        Stack<String> pilaStr = new StackArray<>(3);
        try {
            pilaStr.push("Hola");
            pilaStr.push("Mundo");
            System.out.println(pilaStr); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
