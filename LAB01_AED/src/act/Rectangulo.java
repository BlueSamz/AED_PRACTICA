package act;
import java.util.*;

public class Rectangulo {
	//Esquinas opuestas al rectangulo
    private Coordenada esquina1;  
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquina1(c1);
        setEsquina2(c2);
    }

    // Método setter para esquina1
    public void setEsquina1(Coordenada coo) {
        this.esquina1 = new Coordenada(coo); // Se usa el constructor de copia para evitar aliasing 
    }

    // Método setter para esquina2
    public void setEsquina2(Coordenada coo) {
        this.esquina2 = new Coordenada(coo);
    }

    // Método getter para esquina1
    public Coordenada getEsquina1() {
        return new Coordenada(esquina1); // Se retorna una copia para evitar modificaciones externas
    }

    // Método getter para esquina2
    public Coordenada getEsquina2() {
        return new Coordenada(esquina2);
    }
    
    public double calcularArea() {		//Devuelve el area del rectangulo, usando la diferencia entre las coordenadas
    	return Math.abs((esquina2.getX() - esquina1.getX())*(esquina2.getY() - esquina1.getY()));
    }
    
    // Calcula el area de sobreposicion entre dos rectangulos
    public static Rectangulo areaSobreposicion(Rectangulo r1, Rectangulo r2) {
    	// determina los límites
        double x_min = Math.max(Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()), 
                                Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double x_max = Math.min(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                                Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double y_min = Math.max(Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                                Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
        double y_max = Math.min(Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                                Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));

        // Si hay interseccion, se crea un nuevo rectangulo con las coordenadas de interseccion
        if (x_min < x_max && y_min < y_max) {
            return new Rectangulo(new Coordenada(x_min, y_min), new Coordenada(x_max, y_max));
        }
        return null;  // Retorna null si no hay superposicion 
    }


    // Método toString para representar el rectángulo como una cadena
    @Override
    public String toString() {
        return "(" + esquina1 + ", " + esquina2 + ")";
    }

}
