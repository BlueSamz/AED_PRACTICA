package btree;

import excepciones.ItemNoFound;

public class Main {
	public static void main(String[] args) {
		// Crear un árbol B de enteros con orden 4
		BTree<Integer> btree = new BTree<>(4);

		// Insertar elementos
		int[] datos = {10, 20, 5, 6, 12, 30, 7, 17};

		for (int i : datos) {
			System.out.println("Insertando: " + i);
			btree.insert(i);
			System.out.println(btree);
			System.out.println("------------");
		}

		// Buscar algunas claves
		System.out.println("===== BÚSQUEDAS =====");
		int[] buscar = {12, 52, 6, 99};

		for (int key : buscar) {
			System.out.println("Buscando: " + key);
			boolean encontrado = btree.search(key);
			System.out.println("Resultado: " + encontrado);
			System.out.println("------------");
		}

		// Eliminar elementos
		System.out.println("===== ELIMINACIONES =====");
		int[] eliminar = {6, 17, 10};

		for (int key : eliminar) {
			System.out.println("Eliminando: " + key);
			btree.remove(key);
			System.out.println(btree);
			System.out.println("------------");
		}

	}
}
