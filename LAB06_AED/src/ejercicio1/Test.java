package ejercicio1;

import actividad1.Stack;
import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            StackLink<Integer> pila = new StackLink<>(); 

            pila.push(1);
            pila.push(2);
            pila.push(3);

            System.out.println("Pila: " + pila); 

            System.out.println("Tope: " + pila.top()); 
            System.out.println("Elemento removido: " + pila.pop()); 
            System.out.println("Tamaño actual: " + pila.size()); 
            System.out.println("Contenido actualizado: " + pila);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
