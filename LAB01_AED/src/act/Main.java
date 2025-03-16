package act;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		// Se crea objetos para el ingreso de esquinas de cada rectangulo
		System.out.println("Ingrese una esquina del 1er rectangulo: ");
		Coordenada c1 = new Coordenada(entrada.nextDouble(), entrada.nextDouble());
		System.out.println("Ingrese la esquina opuesta del 1er rectangulo: ");
		Coordenada c2 = new Coordenada(entrada.nextDouble(), entrada.nextDouble());
		Rectangulo A = new Rectangulo(c1, c2);
		
		System.out.println("Ingrese una esquina para el 2do rectangulo: ");
		Coordenada c3 = new Coordenada(entrada.nextDouble(), entrada.nextDouble());
		System.out.println("Ingrese la esquina opuesta del 2do rectangulo: ");
		Coordenada c4 = new Coordenada(entrada.nextDouble(), entrada.nextDouble());
		Rectangulo B = new Rectangulo(c3,c4);
		
		// imprime mensaje
		System.out.println("Rectangulo A = " + A);
		System.out.println("Rectangulo B = " + B);
		
		// Verifica si los rectangulos se sobreponen, estan juntos o disjuntos
		if (Verificador.esSobrePos(A, B)) {
            System.out.println("Los rectangulos A y B se sobreponen.");
            Rectangulo sobreposicion = Rectangulo.areaSobreposicion(A,B);
            // determina el area de sobreposicion y lo muestra
            if (sobreposicion != null) {
            	System.out.println("Area de sobreposicion: "+ sobreposicion.calcularArea());
            }
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Los rectangulos A y B están juntos.");
        } else {
            System.out.println("Los rectangulos A y B son disjuntos.");
        }
	}
}
