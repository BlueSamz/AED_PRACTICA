package btree;

import excepciones.ItemNoFound;

public class MainArchivo {
	public static void main(String[] args) {
        try {
            BTree<Integer> arbol = BTree.building_Btree("arbolB.txt");
            System.out.println("Árbol B construido correctamente:");
            System.out.println(arbol);
        } catch (ItemNoFound ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
