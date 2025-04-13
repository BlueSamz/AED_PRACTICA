package actividad;

public class Hanoi {

    public static void main(String[] args) {
        //llamada al método recursivo
        torresHanoi(5, 1, 2, 3); 
    }

    public static void torresHanoi(int discos, int torre1, int torre2, int torre3) { 
        // Si solo hay un disco, se mueve directamente de la torre 1 a la torre 3
        if (discos == 1) {
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {
            //mueve discos-1 de la torre 1 a la torre 2 usando la torre 3 como auxiliar
            torresHanoi(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            
            //mueve discos-1 de la torre 2 a la torre 3 usando la torre 1 como auxiliar
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}
