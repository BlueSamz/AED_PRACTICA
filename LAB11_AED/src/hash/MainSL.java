package hash;

public class MainSL {
    public static void main(String[] args) {
        System.out.println("====== 1. Insertar sin colisiones (Hash Abierto) ======");
        HashO tabla1 = new HashO(7); // Hash con encadenamiento, sin colisiones
        tabla1.insert(new Register(3, "tres"));
        tabla1.insert(new Register(10, "diez"));
        tabla1.insert(new Register(17, "diecisiete"));
        tabla1.insert(new Register(24, "veinticuatro"));
        tabla1.printTable();

        System.out.println("\n====== 2. Resolver colisiones con sondeo lineal (Hash Cerrado) ======");
        HashC tabla2 = new HashC(6);
        int[] claves2 = {12, 18, 24, 30};
        for (int clave : claves2) {
            tabla2.insert(new Register(clave, String.valueOf(clave)));
            tabla2.printTable();
            System.out.println();
        }
        System.out.println("→ Explicación: Todos los valores hacen key % 6 = 0, así que colisionan. El sistema usa sondeo lineal para encontrar el siguiente espacio libre en la tabla.");

        System.out.println("\n====== 3. Buscar en hash abierto (con encadenamiento) ======");
        HashO tabla3 = new HashO(5);
        tabla3.insert(new Register(10, "Juan"));
        tabla3.insert(new Register(15, "Ana"));
        tabla3.insert(new Register(20, "Luis"));
        tabla3.insert(new Register(25, "Rosa"));
        tabla3.printTable();

        System.out.println("\n→ Buscar clave 20:");
        Register r20 = tabla3.search(20);
        if (r20 != null) System.out.println("Encontrado: " + r20.getName());
        else System.out.println("No encontrado");

        System.out.println("→ Buscar clave 30:");
        Register r30 = tabla3.search(30);
        if (r30 != null) System.out.println("Encontrado: " + r30.getName());
        else System.out.println("No encontrado (clave 30 no existe)");

        System.out.println("\n====== 4. Eliminar en hash cerrado (sondeo lineal) ======");
        HashC tabla4 = new HashC(7);
        tabla4.insert(new Register(5, "cinco"));   // 5 % 7 = 5
        tabla4.insert(new Register(12, "doce"));   // 12 % 7 = 5 → colisión → va al 6
        tabla4.insert(new Register(19, "diecinueve")); // 19 % 7 = 5 → colisiones → va al 0
        System.out.println("Tabla antes de eliminar:");
        tabla4.printTable();

        System.out.println("\n→ Eliminando clave 12 (lógica):");
        tabla4.delete(12);

        System.out.println("Tabla después de eliminar:");
        tabla4.printTable();

        System.out.println("\n→ Buscar clave 19 después de eliminar:");
        Register r19 = tabla4.search(19);
        if (r19 != null) System.out.println("Encontrado: " + r19.getName());
        else System.out.println("No encontrado");

        System.out.println("\n→ Diferencia eliminación lógica vs física:");
        System.out.println("- Eliminación lógica: solo se marca como disponible, NO se borra físicamente el objeto.");
        System.out.println("- Eliminación física: se borra completamente el contenido de la celda (no recomendable en sondeo lineal, rompe la búsqueda).");
    }
}
