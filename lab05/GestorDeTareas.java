package lab05;

import java.util.*;

public class GestorDeTareas<T extends Comparable<T>> {
    private Node<T> first;
    private List<T> completadas;

    public GestorDeTareas() {
        this.first = null;
        this.completadas = new ArrayList<>();
    }

    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (first == null) {
            first = nuevo;
        } else {
            Node<T> actual = first;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (first == null) return false;
        if (first.dato.equals(tarea)) {
            first = first.siguiente;
            return true;
        }
        Node<T> actual = first;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(tarea)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }
        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> actual = first;
        while (actual != null) {
            if (actual.dato.equals(tarea)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> actual = first;
        if (actual == null) {
            System.out.println("(Sin tareas)");
            return;
        }
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    public int contarTareas() {
        int contador = 0;
        Node<T> actual = first;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public T obtenerTareaMasPrioritaria() {
        if (first == null || !(first.dato instanceof Comparable)) return null;
        Node<T> actual = first;
        T max = first.dato;
        while (actual != null) {
            if (actual.dato.compareTo(max) < 0) {
                max = actual.dato;
            }
            actual = actual.siguiente;
        }
        return max;
    }

    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = first;
        while (actual != null) {
            Node<T> siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        first = anterior;
    }

    public void completarTarea(T tarea) {
        if (eliminarTarea(tarea)) {
            completadas.add(tarea);
        }
    }

    public void mostrarTareasCompletadas() {
        if (completadas.isEmpty()) {
            System.out.println("(Sin tareas completadas)");
            return;
        }
        for (T tarea : completadas) {
            System.out.println("- [Completada] " + tarea);
        }
    }

    public void ordenarTareas() {
        List<T> lista = new ArrayList<>();
        Node<T> actual = first;
        while (actual != null) {
            lista.add(actual.dato);
            actual = actual.siguiente;
        }
        Collections.sort(lista);
        first = null;
        for (T tarea : lista) {
            agregarTarea(tarea);
        }
    }
}
