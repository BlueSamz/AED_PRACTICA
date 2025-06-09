package graph;

import java.util.*;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V v) {
        if (!searchVertex(v)) {
            secVertex.add(new VertexObj<>(v, secVertex.size()));
        }
    }

    public void insertEdge(V v, V z) {
        VertexObj<V, E> vert1 = getVertexObj(v);
        VertexObj<V, E> vert2 = getVertexObj(z);

        if (vert1 != null && vert2 != null && !searchEdge(v, z)) {
            secEdge.add(new EdgeObj<>(vert1, vert2, null, secEdge.size()));
        }
    }

    public boolean searchVertex(V v) {
        return getVertexObj(v) != null;
    }

    public boolean searchEdge(V v, V z) {
        for (EdgeObj<V, E> edge : secEdge) {
            if ((edge.endVertex1.info.equals(v) && edge.endVertex2.info.equals(z)) ||
                (edge.endVertex1.info.equals(z) && edge.endVertex2.info.equals(v))) {
                return true;
            }
        }
        return false;
    }

    private VertexObj<V, E> getVertexObj(V v) {
        for (VertexObj<V, E> vert : secVertex) {
            if (vert.info.equals(v)) {
                return vert;
            }
        }
        return null;
    }

    public void bfs(V v) {
        VertexObj<V, E> start = getVertexObj(v);
        if (start == null) return;

        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.print(current.info + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;
                if (edge.endVertex1.equals(current) && !visited.contains(edge.endVertex2)) {
                    neighbor = edge.endVertex2;
                } else if (edge.endVertex2.equals(current) && !visited.contains(edge.endVertex1)) {
                    neighbor = edge.endVertex1;
                }
                if (neighbor != null) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
    public int gradoNodo(V v) {
        int grado = 0;
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.endVertex1.info.equals(v) || edge.endVertex2.info.equals(v)) {
                grado++;
            }
        }
        return grado;
    }

    // Camino: grafo conexo con todos los nodos conectados en cadena sin conectar primero y último
    public boolean esCamino() {
        if (!esConexo()) return false;

        int nodosConGrado1 = 0;
        int nodosConGrado2 = 0;

        for (VertexObj<V, E> v : secVertex) {
            int g = gradoNodo(v.info);
            if (g == 1) nodosConGrado1++;
            else if (g == 2) nodosConGrado2++;
            else if (g != 2 && g != 1) return false;
        }

        // Para un camino válido debe haber exactamente 2 nodos con grado 1 (extremos)
        // y el resto con grado 2
        return nodosConGrado1 == 2 && nodosConGrado2 == secVertex.size() - 2;
    }

    // Ciclo: grafo conexo y todos nodos con grado 2
    public boolean esCiclo() {
        if (!esConexo()) return false;

        for (VertexObj<V, E> v : secVertex) {
            if (gradoNodo(v.info) != 2) return false;
        }
        return true;
    }

    // Rueda: Un nodo conectado a todos los demás, y los demás forman un ciclo
    public boolean esRueda() {
        if (secVertex.size() < 4) return false; // mínimo 4 nodos para rueda

        // Buscar nodo que se conecta con todos los demás (grado = n-1)
        VertexObj<V, E> nodoCentro = null;
        for (VertexObj<V, E> v : secVertex) {
            if (gradoNodo(v.info) == secVertex.size() - 1) {
                nodoCentro = v;
                break;
            }
        }
        if (nodoCentro == null) return false;

        // Verificar que los demás nodos (sin el centro) formen un ciclo
        GraphListEdge<V, E> subGrafo = new GraphListEdge<>();
        for (VertexObj<V, E> v : secVertex) {
            if (!v.equals(nodoCentro)) subGrafo.insertVertex(v.info);
        }
        for (EdgeObj<V, E> e : secEdge) {
            if (!e.endVertex1.equals(nodoCentro) && !e.endVertex2.equals(nodoCentro)) {
                subGrafo.insertEdge(e.endVertex1.info, e.endVertex2.info);
            }
        }
        return subGrafo.esCiclo();
    }

    // Completo: cada nodo conectado con todos los demás (grado = n-1)
    public boolean esCompleto() {
        int n = secVertex.size();
        for (VertexObj<V, E> v : secVertex) {
            if (gradoNodo(v.info) != n - 1) return false;
        }
        return true;
    }

    // Verifica que el grafo sea conexo
    public boolean esConexo() {
        if (secVertex.isEmpty()) return true;

        Set<VertexObj<V, E>> visitados = new HashSet<>();
        Queue<VertexObj<V, E>> cola = new LinkedList<>();

        cola.add(secVertex.get(0));
        visitados.add(secVertex.get(0));

        while (!cola.isEmpty()) {
            VertexObj<V, E> actual = cola.poll();

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> vecino = null;
                if (edge.endVertex1.equals(actual) && !visitados.contains(edge.endVertex2)) {
                    vecino = edge.endVertex2;
                } else if (edge.endVertex2.equals(actual) && !visitados.contains(edge.endVertex1)) {
                    vecino = edge.endVertex1;
                }
                if (vecino != null) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return visitados.size() == secVertex.size();
    }
    
 // Retorna el grado de salida del nodo (cantidad de aristas que parten del nodo)
    public int gradoSalida(V v) {
        VertexObj<V, E> vert = getVertexObj(v);
        if (vert == null) return -1;
        int count = 0;
        for (EdgeObj<V, E> e : secEdge) {
            if (e.endVertex1.equals(vert)) count++;
        }
        return count;
    }

    // Retorna el grado de entrada del nodo (cantidad de aristas que llegan al nodo)
    public int gradoEntrada(V v) {
        VertexObj<V, E> vert = getVertexObj(v);
        if (vert == null) return -1;
        int count = 0;
        for (EdgeObj<V, E> e : secEdge) {
            if (e.endVertex2.equals(vert)) count++;
        }
        return count;
    }

    // Verifica si el grafo es un camino dirigido (P3, P4...)
    public boolean esCaminoDirigido() {
        int inicio = 0, fin = 0, intermedios = 0;
        for (VertexObj<V, E> v : secVertex) {
            int in = gradoEntrada(v.info);
            int out = gradoSalida(v.info);
            if (in == 0 && out == 1) inicio++;
            else if (in == 1 && out == 0) fin++;
            else if (in == 1 && out == 1) intermedios++;
            else return false;
        }
        return inicio == 1 && fin == 1 && (inicio + fin + intermedios == secVertex.size());
    }

    // Verifica si el grafo es un ciclo dirigido (C3, C4...)
    public boolean esCicloDirigido() {
        for (VertexObj<V, E> v : secVertex) {
            if (gradoEntrada(v.info) != 1 || gradoSalida(v.info) != 1) return false;
        }
        return true;
    }

    // Verifica si el grafo es una rueda dirigida (W4, W5...)
    public boolean esRuedaDirigida() {
        int centro = -1;
        for (int i = 0; i < secVertex.size(); i++) {
            int in = gradoEntrada(secVertex.get(i).info);
            int out = gradoSalida(secVertex.get(i).info);
            if (in == secVertex.size() - 1 && out == secVertex.size() - 1) {
                if (centro == -1) centro = i;
                else return false; // más de un centro
            }
        }

        if (centro == -1) return false;

        // Verifica si los demás forman un ciclo dirigido entre sí
        List<VertexObj<V, E>> perifericos = new ArrayList<>(secVertex);
        perifericos.remove(centro);

        for (VertexObj<V, E> v : perifericos) {
            int in = gradoEntrada(v.info);
            int out = gradoSalida(v.info);
            if (in != 2 || out != 2) return false;
        }
        return true;
    }

    // Verifica si el grafo dirigido es completo (Kx)
    public boolean esCompletoDirigido() {
        int n = secVertex.size();
        for (VertexObj<V, E> v1 : secVertex) {
            for (VertexObj<V, E> v2 : secVertex) {
                if (!v1.equals(v2)) {
                    if (!searchEdgeDirigido(v1.info, v2.info)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //búsqueda de arista dirigida (de -> a)
    private boolean searchEdgeDirigido(V from, V to) {
        for (EdgeObj<V, E> e : secEdge) {
            if (e.endVertex1.info.equals(from) && e.endVertex2.info.equals(to)) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarFormal() {
        System.out.print("V = { ");
        for (VertexObj<V, E> v : secVertex) {
            System.out.print(v.info + " ");
        }
        System.out.println("}");

        System.out.print("E = { ");
        for (EdgeObj<V, E> e : secEdge) {
            System.out.print("(" + e.endVertex1.info + ", " + e.endVertex2.info + ") ");
        }
        System.out.println("}");
    }

    public void mostrarListaAdyacencia() {
        for (VertexObj<V, E> v : secVertex) {
            System.out.print(v.info + ": ");
            for (EdgeObj<V, E> e : secEdge) {
                if (e.endVertex1.equals(v)) {
                    System.out.print(e.endVertex2.info + " ");
                } else if (e.endVertex2.equals(v)) {
                    System.out.print(e.endVertex1.info + " ");
                }
            }
            System.out.println();
        }
    }

    public void mostrarMatrizAdyacencia() {
        int n = secVertex.size();
        int[][] matriz = new int[n][n];

        // Llenar la matriz
        for (EdgeObj<V, E> e : secEdge) {
            int i = e.endVertex1.position;
            int j = e.endVertex2.position;
            matriz[i][j] = 1;
            matriz[j][i] = 1; //No dirigido
        }

        //encabezado
        System.out.print("   ");
        for (VertexObj<V, E> v : secVertex) {
            System.out.print(v.info + " ");
        }
        System.out.println();

        //filas
        for (int i = 0; i < n; i++) {
            System.out.print(secVertex.get(i).info + "  ");
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean esIsomorfo(GraphListEdge<V, E> otro) {
        if (this.secVertex.size() != otro.secVertex.size() || this.secEdge.size() != otro.secEdge.size()) {
            return false;
        }

        // Comparar lista de adyacencia
        for (VertexObj<V, E> v : this.secVertex) {
            VertexObj<V, E> vOtro = otro.getVertexObj(v.info);
            if (vOtro == null) return false;

            List<V> ady1 = this.getAdyacentes(v.info);
            List<V> ady2 = otro.getAdyacentes(vOtro.info);
            if (!new HashSet<>(ady1).equals(new HashSet<>(ady2))) return false;
        }

        return true;
    }

    private List<V> getAdyacentes(V vert) {
        List<V> adyacentes = new ArrayList<>();
        VertexObj<V, E> v = getVertexObj(vert);
        if (v == null) return adyacentes;

        for (EdgeObj<V, E> e : secEdge) {
            if (e.endVertex1.equals(v)) adyacentes.add(e.endVertex2.info);
        }
        return adyacentes;
    }

    public boolean esPlano() {
        int v = secVertex.size();
        int e = secEdge.size();
        return e <= 3 * v - 6;
    }

    public boolean esAutoComplementario() {
        GraphListEdge<V, E> complemento = new GraphListEdge<>();
        for (VertexObj<V, E> v : secVertex) {
            complemento.insertVertex(v.info);
        }

        // Insertar aristas que no existen
        for (VertexObj<V, E> v1 : secVertex) {
            for (VertexObj<V, E> v2 : secVertex) {
                if (!v1.equals(v2) && !this.searchEdge(v1.info, v2.info)) {
                    complemento.insertEdge(v1.info, v2.info);
                }
            }
        }

        return this.esIsomorfo(complemento);
    }

}  
