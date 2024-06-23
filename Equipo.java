public class Equipo {
    private String nombre;
    private int victorias;
    private int empates;
    private int derrotas;

    public Equipo(String nombre, int victorias, int empates, int derrotas) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    public String mostrarInfo() {
        return "Equipo: " + nombre + "\nVictorias: " + victorias + "\nEmpates: " + empates + "\nDerrotas: " + derrotas;
    }

    public String getNombre() {
        return nombre;
    }
}
