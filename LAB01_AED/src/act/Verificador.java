package act;

public class Verificador {
	// verifica si los rectangulos se sobreponen
	public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        Rectangulo sobreposicion = Rectangulo.areaSobreposicion(r1, r2); //lama al metodo estatico 
        return sobreposicion != null;   //Retorna true si sobreposicion es diferente de null
    }
	
	//Verifica si los rectangulos estan juntos, sin sobreponerse
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
    	// Obtiene las coordenadas minimas y maximas de cada rectangulo
        double x1_min = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double x1_max = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double y1_min = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        double y1_max = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        double x2_min = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double x2_max = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double y2_min = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        double y2_max = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        
        //Verifica si los rectangulos se tocan horizontalmente
        boolean tocanHorizontal = (x1_max == x2_min || x2_max == x1_min) && (y1_max > y2_min && y2_max > y1_min);
        //verifica si se tocan verticalmente
        boolean tocanVertical = (y1_max == y2_min || y2_max == y1_min) && (x1_max > x2_min && x2_max > x1_min);
        
        return tocanHorizontal || tocanVertical;  //Devuelme true si los rectangulos se tocan
    }
    
}
