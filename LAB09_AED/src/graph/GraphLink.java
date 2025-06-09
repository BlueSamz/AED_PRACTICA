package graph; 

import Queue.QueueLink; // Cola 
import Stack.StackArray; // Pila 
import java.util.ArrayList;
import java.util.Comparator; 
import java.util.HashMap; // Mapa para relaciones clave-valor
import java.util.PriorityQueue; 
import list.ListLinked;

public class GraphLink<E> {

    // Lista de vértices del grafo
    protected ListLinked<Vertex<E>> listVertex;

    // Constructor del grafo, inicializa la lista de vértices
    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    // Inserta un vértice si no existe aún
    public void insertVertex(E data) {
        if (searchVertex(data) == null) // Si el vértice no existe
            listVertex.insertLast(new Vertex<>(data)); // Se inserta al final
    }

    // Inserta una arista no dirigida entre dos vértices
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vertexV = searchVertex(verOri); // Busca vértice origen
        Vertex<E> vertexZ = searchVertex(verDes); // Busca vértice destino

        // Si alguno no existe, se crea e inserta
        if (vertexV == null) {
            vertexV = new Vertex<>(verOri);
            listVertex.insertLast(vertexV);
        }
        if (vertexZ == null) {
            vertexZ = new Vertex<>(verDes);
            listVertex.insertLast(vertexZ);
        }

        // Se agregan aristas en ambas direcciones (grafo no dirigido)
        vertexV.listAdj.insertLast(new Edge<>(vertexZ));
        vertexZ.listAdj.insertLast(new Edge<>(vertexV));
    }

    // Busca y retorna un vértice por su dato
    public Vertex<E> searchVertex(E data) {
        ListLinked<Vertex<E>>.Node current = listVertex.getHead(); // Comienza desde el inicio
        while (current != null) {
            if (current.data.getData().equals(data)) {
                return current.data; // Si encuentra, retorna
            }
            current = current.next; // Avanza al siguiente nodo
        }
        return null; // Si no encuentra, retorna null
    }

    // Verifica si existe una arista entre dos vértices
    public boolean searchEdge(E v, E z) {
        Vertex<E> vertexV = searchVertex(v);
        Vertex<E> vertexZ = searchVertex(z);
        if (vertexV == null || vertexZ == null) return false;

        ListLinked<Edge<E>>.Node current = vertexV.listAdj.getHead();
        while (current != null) {
            if (current.data.getRefDest().equals(vertexZ)) {
                return true; // Existe arista
            }
            current = current.next;
        }
        return false;
    }

    // Elimina un vértice y todas las aristas que lo contienen
    public void removeVertex(E data) {
        Vertex<E> vertex = searchVertex(data);
        if (vertex == null) return;

        ListLinked<Vertex<E>>.Node current = listVertex.getHead();
        while (current != null) {
            current.data.listAdj.remove(new Edge<>(vertex)); // Elimina arista hacia el vértice
            current = current.next;
        }

        listVertex.remove(vertex); // Finalmente elimina el vértice
    }

    // Elimina la arista entre dos vértices
    public void removeEdge(E v, E z) {
        Vertex<E> vertexV = searchVertex(v);
        Vertex<E> vertexZ = searchVertex(z);
        if (vertexV == null || vertexZ == null) return;

        vertexV.listAdj.remove(new Edge<>(vertexZ)); // Quita en una dirección
        vertexZ.listAdj.remove(new Edge<>(vertexV)); // Quita en la otra
    }

    // Recorrido DFS (búsqueda en profundidad)
    public void dfs(E startData) {
        Vertex<E> start = searchVertex(startData);
        if (start == null) return;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsHelper(start, visited);
    }

    // Ayudante recursivo del DFS
    private void dfsHelper(Vertex<E> vertex, ListLinked<Vertex<E>> visited) {
        visited.insertLast(vertex); // Marca como visitado
        System.out.println(vertex.getData()); // Muestra el dato

        ListLinked<Edge<E>>.Node current = vertex.listAdj.getHead();
        while (current != null) {
            Vertex<E> neighbor = current.data.getRefDest();
            if (!visited.search(neighbor)) { // Si no ha sido visitado
                dfsHelper(neighbor, visited); // Llamada recursiva
            }
            current = current.next;
        }
    }

    // Representación en texto del grafo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListLinked<Vertex<E>>.Node current = listVertex.getHead();
        while (current != null) {
            sb.append(current.data.toString()); // Añade representación de cada vértice
            current = current.next;
        }
        return sb.toString();
    }

    // Recorrido BFS (búsqueda en anchura)
    public void bfs(E startData) {
        Vertex<E> start = searchVertex(startData);
        if (start == null) return;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        QueueLink<Vertex<E>> queue = new QueueLink<>();

        visited.insertLast(start);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = null;
            try {
                current = queue.dequeue(); // Desencola el vértice
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(current.getData());

            ListLinked<Edge<E>>.Node edgeNode = current.listAdj.getHead();
            while (edgeNode != null) {
                Vertex<E> neighbor = edgeNode.data.getRefDest();
                if (!visited.search(neighbor)) {
                    visited.insertLast(neighbor);
                    queue.enqueue(neighbor);
                }
                edgeNode = edgeNode.next;
            }
        }
    }

    // Retorna el camino más corto en BFS (sin pesos)
    public ArrayList<E> bfsPath(E startData, E endData) {
        Vertex<E> start = searchVertex(startData);
        Vertex<E> end = searchVertex(endData);
        ArrayList<E> path = new ArrayList<>();

        if (start == null || end == null) return path;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        QueueLink<Vertex<E>> queue = new QueueLink<>();
        HashMap<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();

        visited.insertLast(start);
        queue.enqueue(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<E> current = null;
            try {
                current = queue.dequeue();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (current.equals(end)) break;

            ListLinked<Edge<E>>.Node edgeNode = current.listAdj.getHead();
            while (edgeNode != null) {
                Vertex<E> neighbor = edgeNode.data.getRefDest();
                if (!visited.search(neighbor)) {
                    visited.insertLast(neighbor);
                    queue.enqueue(neighbor);
                    parentMap.put(neighbor, current);
                }
                edgeNode = edgeNode.next;
            }
        }

        if (!parentMap.containsKey(end)) return path;

        Vertex<E> step = end;
        while (step != null) {
            path.add(0, step.getData()); // Reconstruye camino en orden
            step = parentMap.get(step);
        }

        return path;
    }

    // Inserta una arista con peso
    public void insertEdgeWeight(E v, E z, int w) {
        Vertex<E> vo = searchVertex(v);
        Vertex<E> zo = searchVertex(z);
        if (vo == null) {
            vo = new Vertex<>(v);
            listVertex.insertLast(vo);
        }
        if (zo == null) {
            zo = new Vertex<>(z);
            listVertex.insertLast(zo);
        }
        vo.listAdj.insertLast(new Edge<>(zo, w));
        zo.listAdj.insertLast(new Edge<>(vo, w)); // Grafo no dirigido
    }

    // Algoritmo de Dijkstra para camino más corto
    public ArrayList<E> shortPath(E v, E z) {
        Vertex<E> start = searchVertex(v);
        Vertex<E> end = searchVertex(z);
        HashMap<Vertex<E>, Integer> dist = new HashMap<>();
        HashMap<Vertex<E>, Vertex<E>> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (ListLinked<Vertex<E>>.Node n = listVertex.getHead(); n != null; n = n.next) {
            dist.put(n.data, Integer.MAX_VALUE); // Inicializa distancias infinitas
            prev.put(n.data, null);
        }
        dist.put(start, 0); // Distancia al origen = 0
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<E> u = pq.poll(); // Vértice con menor distancia
            for (ListLinked<Edge<E>>.Node e = u.listAdj.getHead(); e != null; e = e.next) {
                Vertex<E> v2 = e.data.getRefDest();
                int alt = dist.get(u) + e.data.getWeight(); // Distancia alternativa
                if (alt < dist.get(v2)) {
                    dist.put(v2, alt); // Actualiza si es mejor
                    prev.put(v2, u);
                    pq.add(v2);
                }
            }
        }

        ArrayList<E> path = new ArrayList<>();
        if (dist.get(end) == Integer.MAX_VALUE) return path; // No hay camino

        for (Vertex<E> at = end; at != null; at = prev.get(at)) {
            path.add(0, at.getData()); // Reconstruye camino
        }
        return path;
    }

    // Verifica si el grafo es conexo usando BFS
    public boolean isConexo() {
        if (listVertex.getHead() == null) return true; // Vacío = conexo

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        QueueLink<Vertex<E>> queue = new QueueLink<>();

        Vertex<E> start = listVertex.getHead().data;
        queue.enqueue(start);
        visited.insertLast(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = null;
            try { current = queue.dequeue(); } catch (Exception e) {}

            for (ListLinked<Edge<E>>.Node edge = current.listAdj.getHead(); edge != null; edge = edge.next) {
                Vertex<E> neighbor = edge.data.getRefDest();
                if (!visited.search(neighbor)) {
                    visited.insertLast(neighbor);
                    queue.enqueue(neighbor);
                }
            }
        }

        int totalVertices = 0;
        for (ListLinked<Vertex<E>>.Node n = listVertex.getHead(); n != null; n = n.next) totalVertices++;
        int visitedVertices = 0;
        for (ListLinked<Vertex<E>>.Node n = visited.getHead(); n != null; n = n.next) visitedVertices++;

        return totalVertices == visitedVertices; // Todos visitados = conexo
    }

    // Apila el camino más corto con Dijkstra
    public StackArray<E> Dijkstra(E v, E z) {
        ArrayList<E> path = shortPath(v, z); // Usa Dijkstra
        StackArray<E> stack = new StackArray<>(path.size());
        for (int i = path.size() - 1; i >= 0; i--) {
            stack.push(path.get(i)); // Lo pone en una pila (de destino a origen)
        }
        return stack;
    }

}
