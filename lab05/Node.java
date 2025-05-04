package lab05;

public class Node <T> {
	public T dato;
	public Node <T> siguiente;
	
	public Node(T dato) {
		this.dato = dato;
		this.siguiente = null;
	}
}
