package act;
import java.util.*;

import ej.ContainerRect;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //contenedor de rectángulos con capacidad máxima de 3
        ContainerRect contenedor = new ContainerRect(3);

        // Crear y agregar rectángulos
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese una esquina del " + (i + 1) + "° rectangulo: ");
            Coordenada c1 = new Coordenada(entrada.nextDouble(), entrada.nextDouble());
            System.out.println("Ingrese la esquina opuesta del " + (i + 1) + "° rectangulo: ");
            Coordenada c2 = new Coordenada(entrada.nextDouble(), entrada.nextDouble());
            Rectangulo rect = new Rectangulo(c1, c2);
            contenedor.addRectangulo(rect);
        }

        // Mostrar los rectángulos almacenados en el contenedor
        System.out.println("Contenido del contenedor de rectángulos:");
        System.out.println(contenedor);
    }
}
