package avltree;

import exceptions.ItemDuplicated;

import bstree.LinkedBST;

public class TestAVL {
	public static void main(String[] args) {
		AVLTree<Integer> avl = new AVLTree<>();
		try {
			avl.insert(10);
			avl.insert(20);
			avl.insert(30); // Rotación simple izquierda
			System.out.println(avl);
			System.out.println("\n============================================================");
					avl.insert(5);
					avl.insert(2); // Rotación simple derecha
					System.out.println(avl);
					System.out.println("\n========================================================= ===");
							avl.insert(8); // Provoca rotación doble IZQ-DER
							System.out.println(avl);
							System.out.println("\n============================================================");
									avl.insert(25);
									avl.insert(23); // Provoca rotación doble DER-IZQ
									System.out.println(avl);
									System.out.println("\n============================================================");
											System.out.println("--- Recorrido por Amplitud ---");
											avl.recorridoPorAmplitud();
											System.out.println(avl);
											System.out.println("\n============================================================");
													System.out.println("--- Recorrido InOrden ---");
													System.out.println(avl);
													System.out.println("\n============================================================");
															System.out.println("--- Recorrido PreOrden ---");
															System.out.println(avl.recorridoPreorden());
															System.out.println("\n============================================================");
																	System.out.println("eliminando nodo 10 (con dos hijos)...");
																	avl.remove(10);
																	System.out.println("\n============================================================");
																			System.out.println("--- Recorrido por Amplitud después de eliminar 10 ---");
																			avl.recorridoPorAmplitud();
																			System.out.println("\n============================================================");
																					System.out.println("--- InOrden Final ---");
																					System.out.println(avl);
																					System.out.println("\n============================================================");
		} catch (ItemDuplicated e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}