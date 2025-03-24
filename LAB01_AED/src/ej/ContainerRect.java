package ej;

import act.Rectangulo;

public class ContainerRect {
    // Atributos de instancia
    private Rectangulo[] rectangulos;
    private double[] distancia;
    private double[] area;
    private int n;  //capacidad maxima
    private static int numRec = 0;  //Atributo de clase para contar los rectangulos agregados

    //constructor que inicializa los arreglos
    public ContainerRect(int capacidad) {
        this.n = capacidad;
        this.rectangulos = new Rectangulo[capacidad];
        this.distancia = new double[capacidad];
        this.area = new double[capacidad];
    }

    //método para agregar un rectangulo al contenedor
    public void addRectangulo(Rectangulo rect) {
        if (numRec < n) {
            rectangulos[numRec] = rect;
            distancia[numRec] = rect.getEsquina1().distancia(rect.getEsquina2());
            area[numRec] = rect.calcularArea();
            numRec++;  //incrementa el contador de rectángulos
        } else {
            System.out.println("No se puede agregar mas rectángulos. Capacidad maxima alcanzada.");
        }
    }

    // Método toString para mostrar los rectangulos con sus distancias y áreas
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s%-30s%-18s%-10s\n", "Rectangulo", "Coordenadas", "Distancia", "Area"));
        for (int i = 0; i < numRec; i++) {
            sb.append(String.format("%-12d%-30s%-18.3f%-10.2f\n", 
                    (i + 1), 
                    rectangulos[i].getEsquina1() + ", " + rectangulos[i].getEsquina2(),
                    distancia[i],
                    area[i]));
        }
        return sb.toString();
    }

}
