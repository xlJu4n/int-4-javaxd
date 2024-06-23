public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Estadio estadio;
    private String dia;
    private String hora;
    private String resultado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Estadio estadio, String dia, String hora) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estadio = estadio;
        this.dia = dia;
        this.hora = hora;
        this.resultado = null;
    }

    public void jugarPartido(String resultado) {
        this.resultado = resultado;
    }

    public String mostrarResultado() {
        if (resultado != null) {
            return "Partido en " + estadio.mostrarInfo() + " - " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + ": " + resultado;
        } else {
            return "Partido en " + estadio.mostrarInfo() + " - " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + ": Aún no jugado";
        }
    }

    public String mostrarInfo() {
        return "Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + "\n" +
               "Estadio: " + estadio.getNombre() + "\n" +
               "Día: " + dia + "\nHora: " + hora;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
}
