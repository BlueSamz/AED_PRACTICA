package hash;

public class TestHashO {
    public static void main(String[] args) {
        // Crear una tabla hash de tamaño pequeño para forzar colisiones
        HashO tabla = new HashO(6); // Tamaño pequeño para generar colisiones fácilmente

        // Insertar registros (algunos generarán colisiones)
        tabla.insert(new Register(1, "Luis"));    // 1 % 6 = 1 (colision con Marco)
        tabla.insert(new Register(6, "Ana"));     // 6 % 6 = 0
        tabla.insert(new Register(11, "Pedro"));  // 11 % 6 = 5
        tabla.insert(new Register(2, "Carla"));   // 2 % 6 = 2
        tabla.insert(new Register(7, "Marco"));   // 7 % 6 = 1 (colisión con Luis)
        tabla.insert(new Register(3, "Lucía"));   // 3 % 6 = 3 (colision con Juan)
        tabla.insert(new Register(4, "Eva"));     // 4 % 6 = 4
        tabla.insert(new Register(9, "Juan"));    // 9 % 6 = 3 (colisión con Lucia)

        // Mostrar la tabla después de insertar
        System.out.println("Contenido de la tabla hash con encadenamiento:");
        tabla.printTable();
    }
}
  