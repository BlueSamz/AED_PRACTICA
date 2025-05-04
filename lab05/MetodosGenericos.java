package lab05;
import java.util.*;

public class MetodosGenericos {

    //Recorre la lista y verifica si el valor está presente
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        return lista.contains(valor);
    }

    //Crea una nueva lista con los mismos elementos en orden inverso
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>(lista);
        Collections.reverse(invertida);
        return invertida;
    }

    //Recorre hasta el último nodo y agrega el nuevo nodo al final
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) return nuevo;
        Node<T> actual = head;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
        return head;
    }

    //Recorre la lista desde el nodo head y cuenta cuántos nodos hay
    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    //Compara cada nodo de ambas listas para ver si son iguales y en el mismo orden
    public static <T> boolean sonIguales(Node<T> l1, Node<T> l2) {
        while (l1 != null && l2 != null) {
            if (!Objects.equals(l1.dato, l2.dato)) return false;
            l1 = l1.siguiente;
            l2 = l2.siguiente;
        }
        return l1 == null && l2 == null;
    }

    //Une dos listas enlazadas conectando el final de la primera con el inicio de la segunda
    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        Node<T> actual = l1;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = l2;
        return l1;
    }

    //Método main para probar los métodos anteriores
    public static void main(String[] args) {
        //Lista con elementos Integer
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Buscar 3: " + buscarElemento(lista, 3)); // true
        System.out.println("Invertida: " + invertirLista(lista)); // [5, 4, 3, 2, 1]

        //Crear una lista enlazada
        Node<String> head = new Node<>("A");
        head = insertarAlFinal(head, "B");
        head = insertarAlFinal(head, "C");
        System.out.println("Nodos en lista: " + contarNodos(head)); // 3

        //Otra lista similar para comparar
        Node<String> otra = new Node<>("A");
        otra = insertarAlFinal(otra, "B");
        otra = insertarAlFinal(otra, "C");
        System.out.println("Listas iguales: " + sonIguales(head, otra)); // true

        //Lista para concatenar
        Node<String> tercera = new Node<>("X");
        Node<String> concatenada = concatenarListas(head, tercera);
        System.out.print("Lista concatenada: ");
        Node<String> actual = concatenada;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
    
}
