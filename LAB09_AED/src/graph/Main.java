package graph;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== GRAFO NO DIRIGIDO ======");
        GraphListEdge<String, String> grafo = new GraphListEdge<>();

        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        grafo.insertEdge("A", "B");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "E");
        grafo.insertEdge("E", "A");

        System.out.println("\nFormal: ");
        grafo.mostrarFormal();
        
        System.out.println("\nLista de adyacencia:");
        grafo.mostrarListaAdyacencia();

        System.out.println("Matriz de adyacencia:");
        grafo.mostrarMatrizAdyacencia();

        System.out.print("BFS desde A: ");
        grafo.bfs("A");
        System.out.println();

        System.out.println("Grado del nodo B: " + grafo.gradoNodo("B"));
        System.out.println("¿Es camino? " + grafo.esCamino());
        System.out.println("¿Es ciclo? " + grafo.esCiclo());
        System.out.println("¿Es rueda? " + grafo.esRueda());
        System.out.println("¿Es completo? " + grafo.esCompleto());
        System.out.println("¿Es conexo? " + grafo.esConexo());

        System.out.println("\n====== GRAFO DIRIGIDO ======");
        GraphListEdge<String, String> grafoDirigido = new GraphListEdge<>();

        grafoDirigido.insertVertex("X");
        grafoDirigido.insertVertex("Y");
        grafoDirigido.insertVertex("Z");

        grafoDirigido.insertEdge("X", "Y");
        grafoDirigido.insertEdge("Y", "Z");
        grafoDirigido.insertEdge("Z", "X");

        System.out.println("\nFormal: ");
        grafo.mostrarFormal();
        
        System.out.println("\nLista de adyacencia:");
        grafo.mostrarListaAdyacencia();

        System.out.println("Matriz de adyacencia:");
        grafoDirigido.mostrarMatrizAdyacencia();

        System.out.print("BFS desde X: ");
        grafoDirigido.bfs("X");
        System.out.println();

        System.out.println("Grado salida de Y: " + grafoDirigido.gradoSalida("Y"));
        System.out.println("Grado entrada de Y: " + grafoDirigido.gradoEntrada("Y"));
        System.out.println("¿Es camino dirigido? " + grafoDirigido.esCaminoDirigido());
        System.out.println("¿Es ciclo dirigido? " + grafoDirigido.esCicloDirigido());
        System.out.println("¿Es rueda dirigida? " + grafoDirigido.esRuedaDirigida());
        System.out.println("¿Es completo dirigido? " + grafoDirigido.esCompletoDirigido());
    }
}
