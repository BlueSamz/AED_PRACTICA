package ejercicio;

public class Select {

	public static int menorElem(int[] arr, int k) {

		return quickSelect(arr, 0, arr.length - 1, k - 1);
	}

	private static int quickSelect(int[] arr, int low, int high, int k) {
		if (low == high) return arr[low];
		int pivIndex = particion(arr, low, high, high); //usa el último como pivote

		if (pivIndex == k) {
			return arr[k]; //encontra el k-ésimo más pequeño
		} else if (pivIndex > k) {
			return quickSelect(arr, low, pivIndex - 1, k); //buscar en la izquierda
		} else {
			return quickSelect(arr, pivIndex + 1, high, k); //buscar en la derecha
		}
	}

	private static int particion(int[] arr, int low, int high, int piv) {
		int piValue = arr[piv];
		int pivIndex = low;

		for (int i = low; i < high; i++) {
			if (arr[i] < piValue) {
				swap(arr, i, pivIndex);
				pivIndex++;
			}
		}
		swap(arr, pivIndex, high); //coloca el pivote en su posición final
		return pivIndex;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arreglo1 = {4, 2, 7, 10, 4, 17};
		int[] arreglo2 = {4, 2, 7, 10, 4, 1, 6};
		int[] arreglo3 = {4, 2, 7, 1, 4, 6};

		System.out.println("Tercer elemento más pequeño en arreglo1: " +
				Select.menorElem(arreglo1, 3));
		System.out.println("Quinto elemento más pequeño en arreglo2: " +
				Select.menorElem(arreglo2, 5));
		System.out.println("Primer elemento más pequeño en arreglo3: " +
				Select.menorElem(arreglo3, 1));
	}
}
