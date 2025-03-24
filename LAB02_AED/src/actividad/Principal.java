package actividad;

public class Principal {
    public static void main(String[] args) {
        // Bolsa de chocolatinas
        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);
        Chocolatina c = new Chocolatina("Milka");
        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Ferrero");

        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        System.out.println("Contenido de la bolsa de chocolatinas:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // Bolsa de golosinas
        Bolsa<Golosina> bolsaGo = new Bolsa<>(3);
        Golosina g = new Golosina("Caramelos", 250);
        Golosina g1 = new Golosina("Galleta", 195);
        Golosina g2 = new Golosina("Toffes", 150);

        bolsaGo.add(g);
        bolsaGo.add(g1);
        bolsaGo.add(g2);

        System.out.println("Contenido de la bolsa de golosinas:");
        for (Golosina golosina : bolsaGo) {
            System.out.println(golosina.getNombre() + " - " + golosina.getPeso() + "g");
        }
    }
}
