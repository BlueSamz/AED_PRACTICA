package lab05;

public class Tarea implements Comparable<Tarea> {
    private String titulo;
    private int prioridad;
    public Tarea(String titulo, int prioridad) {
        this.titulo=titulo;
        this.prioridad=prioridad;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setTitulo(String titulo) {
        this.titulo=titulo;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    @Override
    public String toString() {
        return "Tarea: " + titulo + "(Prioridad: " + prioridad + ")";
    }
    @Override
    public int compareTo(Tarea otraTarea) {
        return Integer.compare(otraTarea.getPrioridad(), this.prioridad); 
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj;
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo);
    }
}

