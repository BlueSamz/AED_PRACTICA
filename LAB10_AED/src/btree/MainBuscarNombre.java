package btree;

public class MainBuscarNombre {
	public static void main(String[] args) {
        // Crear árbol B de orden 4 para objetos RegistroEstudiante
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        // Insertar estudiantes
        RegistroEstudiante[] estudiantes = {
            new RegistroEstudiante(103, "Ana"),
            new RegistroEstudiante(110, "Luis"),
            new RegistroEstudiante(101, "Carlos"),
            new RegistroEstudiante(120, "Lucía"),
            new RegistroEstudiante(115, "David"),
            new RegistroEstudiante(125, "Jorge"),
            new RegistroEstudiante(140, "Camila"),
            new RegistroEstudiante(108, "Rosa"),
            new RegistroEstudiante(132, "Ernesto"),
            new RegistroEstudiante(128, "Denis"),
            new RegistroEstudiante(145, "Enrique"),
            new RegistroEstudiante(122, "Karina"),
            new RegistroEstudiante(108, "Juan") // Duplicado
        };

        for (RegistroEstudiante e : estudiantes) {
            arbol.insert(e);
        }

        System.out.println("===== BÚSQUEDAS =====");
        System.out.println("Buscar 115: " + arbol.buscarNombre(115)); // David
        System.out.println("Buscar 132: " + arbol.buscarNombre(132)); // Ernesto
        System.out.println("Buscar 999: " + arbol.buscarNombre(999)); // No encontrado

        System.out.println("\n===== ELIMINACIÓN =====");
        arbol.remove(new RegistroEstudiante(101, "")); 
        System.out.println("Eliminado 101. Buscar 101: " + arbol.buscarNombre(101)); // No encontrado

        System.out.println("\n===== INSERCIÓN ADICIONAL =====");
        arbol.insert(new RegistroEstudiante(106, "Sara"));
        System.out.println("Buscar 106: " + arbol.buscarNombre(106)); 

        System.out.println("\n===== ESTRUCTURA DEL ÁRBOL B =====");
        System.out.println(arbol);
    }
}
