package hash;

/**
 * Implementación de una tabla hash usando hash cerrado (sondeo lineal).
 */
public class HashC {

    /**
     * Clase interna para representar una celda de la tabla hash.
     * El estudiante puede usar esta clase tal como está.
     */
    private static class Element {
        Register register;   // Registro guardado
        boolean isAvailable; // Indica si la celda esta disponible

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table; // Arreglo de elementos (la tabla hash)
    private int size;        // Tamaño de la tabla

    /**
     * Constructor de la clase HashC.
     * El estudiante debe inicializar el arreglo de Element con el tamaño indicado.
     */
    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    /**
     * Función hash para calcular el índice a partir de la clave.
     * El estudiante puede usar: key % size
     */
    private int hash(int key) {
        return key % size;
    }

    /**
     * Método para insertar un nuevo registro en la tabla hash.
     * Debe usar sondeo lineal para encontrar una celda disponible.
     * Si la tabla está llena, mostrar un mensaje de error.
     */
    public void insert(Register reg) {
        int key = reg.getKey();
        int index = hash(key);
        int originalIndex = index;
        boolean inserted = false;

        do {
            System.out.println("→ Intentando en índice " + index);
            if (table[index].isAvailable) {
                table[index].register = reg;
                table[index].isAvailable = false;
                System.out.println("Insertado en índice " + index);
                inserted = true;
                break;
            } else {
                System.out.println("Colisión en índice " + index + ", probando siguiente...");
            }
            index = (index + 1) % size;
        } while (index != originalIndex);

        if (!inserted) {
            System.out.println("Tabla llena. No se pudo insertar la clave " + key);
        }
    }


    /**
     * Método para buscar un registro en la tabla por su clave.
     * Debe recorrer usando sondeo lineal hasta encontrar la clave o determinar que no está.
     */
    public Register search(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                return table[index].register; 
            } else if (table[index].isAvailable && table[index].register == null) {
                return null; // celda nunca ocupada, se puede dejar de buscar
            }
            index = (index + 1) % size;
        } while (index != originalIndex);

        return null;
    }

    /**
     * Método para eliminar un registro de forma lógica (no física).
     * Marcar la celda como disponible sin eliminar el objeto Element.
     */
    public void delete(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                table[index].register = null;
                table[index].isAvailable = true;
                System.out.println("Registro eliminado lógicamente.");
                return;
            } else if (table[index].isAvailable && table[index].register == null) {
                System.out.println("Clave no encontrada.");
                return;
            }
            index = (index + 1) % size;
        } while (index != originalIndex);

        System.out.println("Clave no encontrada.");
    }

    /**
     * Método para imprimir el estado actual de la tabla hash.
     * Debe recorrer la tabla e imprimir cada índice con su contenido (o vacío).
     */
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "]: ");
            if (table[i].register != null && !table[i].isAvailable) {
                System.out.println("Clave=" + table[i].register.getKey() + ", Valor=" + table[i].register);
            } else {
                System.out.println("Vacío");
            }
        }
    }
}
