package hash;

public class TestHashSinColisiones {
    public static void main(String[] args) {
        // Crear tabla hash de tamaño 7
        HashC tabla = new HashC(7);

        // Insertar valores que NO colisionan
        tabla.insert(new Register(3, "Tres"));     // 3 % 7 = 3
        tabla.insert(new Register(10, "Diez"));    // 10 % 7 = 3 → colisión ⚠️
        tabla.insert(new Register(17, "ez"));  
        tabla.insert(new Register(24, "Di"));  

        // Mostrar la tabla
        System.out.println("Tabla Hash con colisiones:");
        tabla.printTable();
    }
}
