package bstreelinklistinterfgeneric;
import clasesAuxiliares.Queue;
import clasesAuxiliares.QueueLink;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node raiz;

    @Override
    public void insert(E data) throws ItemDuplicated {
        raiz = insert(raiz, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null) return new Node(data);
        int comp = data.compareTo(node.data);
        if (comp < 0) {
            node.left = insert(node.left, data);
        } else if (comp > 0) {
            node.right = insert(node.right, data);
        } else {
            throw new ItemDuplicated("Ya existe: " + data);
        }
        return node;
    }

    @Override
    public boolean search(E data) throws ItemNoFound {
        return search(raiz, data) != null;
    }

    private Node search(Node node, E data) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("No se encontro: " + data);
        int comp = data.compareTo(node.data);
        if (comp < 0) return search(node.left, data);
        else if (comp > 0) return search(node.right, data);
        else return node;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (estaVacio()) throw new ExceptionIsEmpty("Arbol vacio");
        raiz = delete(raiz, data);
    }

    private Node delete(Node node, E data) throws ExceptionIsEmpty {
        if (node == null) throw new ExceptionIsEmpty("No se encontro: " + data);
        int comp = data.compareTo(node.data);
        if (comp < 0) {
            node.left = delete(node.left, data);
        } else if (comp > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = buscarMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    @Override
    public void destroy() {
        raiz = null;
    }

    @Override
    public boolean isEmpty() {
        return estaVacio();
    }

    private boolean estaVacio() {
        return raiz == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        recorridoInOrden(raiz, sb);
        return sb.toString().trim();
    }

    private void recorridoInOrden(Node node, StringBuilder sb) {
        if (node != null) {
            recorridoInOrden(node.left, sb);
            sb.append(node.data).append(" ");
            recorridoInOrden(node.right, sb);
        }
    }

    public void preOrder() {
        preOrder(raiz);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(raiz);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    private Node buscarMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node buscarMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }
    
    public void destroyNodes() throws ExceptionIsEmpty {
        if (raiz == null) {
            throw new ExceptionIsEmpty("El arbol esta vacio");
        }
        raiz = null;
    }
    
    public int countAllNodes() {
        return contar(raiz);
    }

    private int contar(Node nodo) {
        if (nodo == null) return 0;
        if (nodo.left == null && nodo.right == null) return 0;
        return 1 + contar(nodo.left) + contar(nodo.right);
    }

    
    public int countNodes() {
        return countAllNodes();
    }
    
    public int height(E x) {
        Node nodo = raiz;

        while (nodo != null) {
            int cmp = x.compareTo(nodo.data);
            if (cmp == 0) break;
            if (cmp < 0) nodo = nodo.left;
            else nodo = nodo.right;
        }

        if (nodo == null) return -1;

        return altura(nodo);
    }

    private int altura(Node nodo) {
        if (nodo == null) 
        	return -1;
        int izq = altura(nodo.left);
        int der = altura(nodo.right);
        return 1 + Math.max(izq, der);
    }
    
    public int amplitude(int nivel) {
        return contarNivel(raiz, nivel);
    }

    private int contarNivel(Node nodo, int nivel) {
        if (nodo == null) 
        	return 0;
        if (nivel == 0) return 1;
        return contarNivel(nodo.left, nivel - 1) + contarNivel(nodo.right, nivel - 1);
    }

    public int areaBST() {
        int hojas = contarHojas(raiz);
        int altura = alturaTotal(raiz);
        return hojas * altura;
    }

    private int contarHojas(Node nodo) {
        if (nodo == null) 
        	return 0;
        if (nodo.left == null && nodo.right == null) return 1;
        return contarHojas(nodo.left) + contarHojas(nodo.right);
    }

    private int alturaTotal(Node nodo) {
        if (nodo == null) 
        	return 0;
        int izq = alturaTotal(nodo.left);
        int der = alturaTotal(nodo.right);
        return 1 + Math.max(izq, der);
    }

 // Método iterativo del área (hojas * altura)
    public int areaBSTIterative() throws ExceptionIsEmpty {
        if (raiz == null) return 0;

        int hojas = 0;
        Queue<Node> cola = new QueueLink<>();
        cola.enqueue(raiz);

        while (!cola.isEmpty()) {
            Node actual = cola.dequeue();

            if (actual.left == null && actual.right == null) {
                hojas++;
            }

            if (actual.left != null) cola.enqueue(actual.left);
            if (actual.right != null) cola.enqueue(actual.right);
        }

        int altura = alturaTotalIterativa();
        return hojas * altura;
    }

    private int alturaTotalIterativa() throws ExceptionIsEmpty {
        if (raiz == null) return 0;

        Queue<Node> cola = new QueueLink<>();
        cola.enqueue(raiz);
        int altura = 0;

        while (!cola.isEmpty()) {
            int size = cola.size();
            for (int i = 0; i < size; i++) {
                Node actual = cola.dequeue();
                if (actual.left != null) cola.enqueue(actual.left);
                if (actual.right != null) cola.enqueue(actual.right);
            }
            altura++;
        }

        return altura;
    }

    // Método drawBST()
    public void drawBST() {
        drawBST(raiz, 0);
    }

    private void drawBST(Node node, int nivel) {
        if (node == null) return;
        drawBST(node.right, nivel + 1);

        for (int i = 0; i < nivel; i++) System.out.print("   ");
        System.out.println(node.data);

        drawBST(node.left, nivel + 1);
    }
    public void parenthesize() {
        parenthesize(raiz, 0);
    }

    private void parenthesize(Node node, int level) {
        if (node == null) return;

        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        
        System.out.println(node.data);
        
        if (node.left != null || node.right != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println("(");
            
            parenthesize(node.left, level + 1);
            
            parenthesize(node.right, level + 1);
            
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(")");
        }
    }



}
