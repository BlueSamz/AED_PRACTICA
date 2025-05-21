package bstreelinklistinterfgeneric;

import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemNoFound;

public class Test {
    public static <T extends Comparable<T>, U extends Comparable<U>> boolean sameArea(LinkedBST<T> a, LinkedBST<U> b) throws ExceptionIsEmpty {
        return a.areaBSTIterative() == b.areaBSTIterative();
    }

    public static void main(String[] args) {
        try {
            LinkedBST<Integer> tree1 = new LinkedBST<>();
            tree1.insert(65);
            tree1.insert(40);
            tree1.insert(85);
            tree1.insert(30);
            tree1.insert(50);
            tree1.insert(70);
            tree1.insert(90);
            tree1.insert(45);

            System.out.println("Árbol dibujado:");
            tree1.drawBST();

            System.out.println("\nRepresentación con paréntesis:");
            tree1.parenthesize();

            System.out.println("\nÁrea del árbol: " + tree1.areaBSTIterative());

            System.out.println("Árbol luego de eliminar 85:");
            tree1.delete(70);  
            tree1.drawBST();

            LinkedBST<Integer> tree2 = new LinkedBST<>();
            tree2.insert(10);
            tree2.insert(7);
            tree2.insert(15);
            tree2.insert(3);
            tree2.insert(5);
            tree2.insert(12);
            tree2.insert(18);

            System.out.println("Segundo árbol:");
            tree2.drawBST();

            System.out.println("Área del segundo árbol: " + tree2.areaBSTIterative());

            System.out.println("Tienen la misma área? " + sameArea(tree1, tree2));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}

