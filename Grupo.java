import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private List<Equipo> equipos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public String mostrarInfo() {
        StringBuilder info = new StringBuilder("Grupo: " + nombre + "\n");
        for (Equipo equipo : equipos) {
            info.append(equipo.mostrarInfo()).append("\n");
        }
        return info.toString();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
}
