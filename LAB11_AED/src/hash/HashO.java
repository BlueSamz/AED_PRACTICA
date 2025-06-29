package hash;

import java.util.LinkedList;

/**
 * Clase que implementa una tabla hash con encadenamiento (listas enlazadas).
 */
public class HashO {
    private LinkedList<Register>[] table; // Arreglo de listas enlazadas
    private int size; //tamaño

    /**
     * Constructor que inicializa el arreglo de listas.
     */
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        // Inicializar cada posición con una nueva lista enlazada vacía
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>(); // Creamos listas vacías en cada índice
        }
    }

    /**
     * Función hash que determina la posición en la tabla.
     */
    private int hash(int key) {
        // Calcular el índice hash usando key % size
        return key % size;
    }

    /**
     * Inserta un registro en la posición adecuada.
     * Los elementos que colisionen deben agregarse a la lista enlazada correspondiente.
     */
    public void insert(Register reg) {
        int index = hash(reg.getKey()); // Calcular índice de inserción
        table[index].add(reg); // Agregar al final de la lista enlazada
    }

    /**
     * Busca un registro por su clave.
     */
    public Register search(int key) {
        int index = hash(key); // Calcular el índice donde debe estar el registro
        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                return reg; // Registro encontrado
            }
        }
        return null; // No encontrado
    }

    /**
     * Elimina un registro por su clave.
     */
    public void delete(int key) {
        int index = hash(key); // Calcular índice donde buscar
        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                table[index].remove(reg); // Eliminar el registro de la lista
                return;
            }
        }
        // Si no se encuentra el registro, no se hace nada
    }

    /**
     * Muestra el contenido de la tabla hash.
     */
    public void printTable() {
        // Recorrer cada posición de la tabla
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("vacío");
            } else {
                for (Register reg : table[i]) {
                    System.out.print("[" + reg.getKey() + ", " + reg + "] ");
                }
                System.out.println();
            }
        }
    }
}
