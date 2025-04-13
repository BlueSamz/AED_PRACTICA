package ejercicio;

import java.util.*;

public class SubconjuntoPotencia {

	public static boolean potencia(int n) { // metodo para obtener potencia a traves de binarios
		return n > 0 && (n & (n - 1)) == 0;
	}
	public static boolean impar(int n) { //metodo para obtener numeros impares
		return n % 2!=0;
	}
	public static int sumaArr(int[] arr) {
		int sum = 0;
		for(int e : arr) { //recorre todo el arreglo para poder sumarlos
			sum += e;
		}
		return sum;
	}
	public static boolean calcular(int []valores) {
		int[] arrAux = new int[valores[0]]; //crea un nuevp arreglo que va a tomar el tamanio del primero arreglo
		int index = 0;
		for(int i=1;i<valores.length - 1 && index < valores[0];i++) { //recorre todo el for
			if(index > valores[0]) break;
			if(potencia(valores[i])) {
				arrAux[index] = valores[i];
				index++;
			}
			if(!(valores[i] % 5 == 0 && impar(valores[i+1]))) { //verifica funciones
				arrAux[index] = valores[i];
			}
		}
		System.out.println("Suma obtenida: " + sumaArr(arrAux));
		return (sumaArr(arrAux) == valores[valores.length - 1]);
	}
	public static void main(String[] args) {
		int[] valores = {4,2,5,7,6,13};
		boolean resultado = calcular(valores);
		System.out.println("¿La suma de los valores coincide con el resultado? " + resultado);
	}
}
