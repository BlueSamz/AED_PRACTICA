package actividad;

import java.util.Arrays;
public class ModaOrdenada {
	public static int moda2(int array[]) {
		int first = 1;
		int p = 0;
		int end = array.length - 1;
		int moda = array[0];
		int frec = 1;
		int maxfrec = 0;
		while (first <= end) {
			if (array[p] == array[first]) {
				frec++;
				first++;
			} else {
				if (frec > maxfrec) {
					maxfrec = frec;
					moda = array[p];
				}
				p = first;
				first = p + 1;
				frec = 1;
			}
		}
		if (frec > maxfrec) {//revisamos por ultima vez por si la moda está al final del arreglo
			moda = array[p];
		}
		return moda;
	}
	public static void main(String[] args) {
		int[] arreglo = {2, 3, 2, 5, 6, 2, 3, 3, 3};
		Arrays.sort(arreglo);
		System.out.println("arreglo ordenado: " + Arrays.toString(arreglo));
		int moda = moda2(arreglo);
		System.out.println("la moda del arreglo es: " + moda);
	}
}
