package hash;

public class TestHash {
    public static void main(String[] args) {
        HashC tabla = new HashC(10); // tamaño elegido a propósito para provocar colisiones

        // Insertar registros con las claves dadas
        tabla.insert(new Register(34, "Ana"));
        tabla.insert(new Register(3, "Luis"));
        tabla.insert(new Register(7, "Marta"));
        tabla.insert(new Register(30, "Pedro"));
        tabla.insert(new Register(11, "Sofía"));
        tabla.insert(new Register(8, "Carlos"));
        tabla.insert(new Register(7, "Julia"));    // Clave duplicada
        tabla.insert(new Register(23, "Marco"));
        tabla.insert(new Register(41, "Elena"));
        tabla.insert(new Register(16, "Diana"));

        System.out.println("Tabla Hash después de insertar:");
        tabla.printTable();

        System.out.println("\nEliminando lógicamente la clave 30:");
        tabla.delete(30);

        System.out.println("\nTabla Hash después de eliminar la clave 30:");
        tabla.printTable();

        System.out.println("\nBuscando la clave 23:");
        Register encontrado = tabla.search(23);
        if (encontrado != null) {
            System.out.println("Registro encontrado: " + encontrado);
        } else {
            System.out.println("Clave 23 no encontrada.");
        }
    }
}
