package actividad;

public class Moda {
	public static int moda1(int[] array) {
		int first = 0;
		int end = array.length - 1;
		if (first == end) {
			return array[first]; //solo hay un elemento
		}
		int moda = array[first];
		int maxfrec = frecuencia(array, first, end, moda);
		for (int i = first + 1; i <= end; i++) {
			int frec = frecuencia(array, i, end, array[i]);
			if (frec > maxfrec) {
				maxfrec = frec;
				moda = array[i];
			}
		}
		return moda;
	}

	private static int frecuencia(int[] array, int first, int end, int ele) {
		if (first > end) return 0;
		int suma = 0;
		for (int i = first; i <= end; i++) {
			if (array[i] == ele) {
				suma++;
			}
		}
		return suma;
	}
	public static void main(String[] args) {
		int[] arreglo = {2, 3, 2, 5, 6, 2, 3, 3, 3};
		int moda = moda1(arreglo);
		System.out.println("la moda del arreglo es: " + moda);
	}
}
