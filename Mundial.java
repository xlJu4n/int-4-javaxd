import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Mundial extends JFrame {
    private Map<String, Grupo> grupos;
    private java.util.List<Partido> partidos; // Nombre completamente cualificado
    private java.util.List<Equipo> equipos;   // Nombre completamente cualificado
    private JComboBox<String> combo;
    private JTextArea infoText;

    public Mundial() {
        setTitle("Mundial 2034");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear menú
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu datosMenu = new JMenu("Datos");
        menuBar.add(datosMenu);

        JMenuItem cargarDatosItem = new JMenuItem("Cargar Datos");
        datosMenu.add(cargarDatosItem);
        cargarDatosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        JMenu partidosMenu = new JMenu("Partidos");
        menuBar.add(partidosMenu);

        JMenuItem mostrarPartidosItem = new JMenuItem("Mostrar Partidos");
        partidosMenu.add(mostrarPartidosItem);
        mostrarPartidosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPartidos();
            }
        });

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // ComboBox para equipos
        combo = new JComboBox<>();
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInfoEquipo();
            }
        });
        panel.add(combo, BorderLayout.NORTH);

        // JTextArea para mostrar información
        infoText = new JTextArea();
        infoText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoText);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private void loadData() {
        Grupo grupoA = new Grupo("Grupo A");
        grupoA.agregarEquipo(new Equipo("Argentina", 3, 1, 1));
        grupoA.agregarEquipo(new Equipo("Corea del Sur", 1, 3, 1));
        grupoA.agregarEquipo(new Equipo("Nigeria", 1, 2, 1));
        grupoA.agregarEquipo(new Equipo("Bosnia Herzegovina", 1, 1, 2));

        Grupo grupoB = new Grupo("Grupo B");
        grupoB.agregarEquipo(new Equipo("Alemania", 3, 1, 1));
        grupoB.agregarEquipo(new Equipo("Portugal", 1, 3, 1));
        grupoB.agregarEquipo(new Equipo("China", 1, 1, 1));
        grupoB.agregarEquipo(new Equipo("Camerun", 1, 0, 0));

        Grupo grupoC = new Grupo("Grupo C");
        grupoC.agregarEquipo(new Equipo("Ecuador", 3, 1, 0));
        grupoC.agregarEquipo(new Equipo("Italia", 3, 3, 1));
        grupoC.agregarEquipo(new Equipo("Australia", 1, 0, 1));
        grupoC.agregarEquipo(new Equipo("Iran", 0, 1, 1));

        Grupo grupoD = new Grupo("Grupo D");
        grupoD.agregarEquipo(new Equipo("España", 3, 3, 1));
        grupoD.agregarEquipo(new Equipo("Uruguay", 3, 1, 0));
        grupoD.agregarEquipo(new Equipo("Estados Unidos", 1, 1, 1));
        grupoD.agregarEquipo(new Equipo("Croacia", 1, 3, 0));

        grupos = new HashMap<>();
        grupos.put("Grupo A", grupoA);
        grupos.put("Grupo B", grupoB);
        grupos.put("Grupo C", grupoC);
        grupos.put("Grupo D", grupoD);

        Estadio estadio1 = new Estadio("El Monumental", "Ciudad de Buenos Aires", 50000);
        Estadio estadio2 = new Estadio("La Bombonera", "Buenos Aires", 70000);
        Estadio estadio3 = new Estadio("Mario Alberto Kempes", "Cordoba", 57000);
        Estadio estadio4 = new Estadio("Libertadores de America", "Buenos Aires", 48069);
        Estadio estadio5 = new Estadio("Ciudad de la Plata", "Buenos Aires", 53000);
        Estadio estadio6 = new Estadio("Marcelo Bielsa", "Santa Fe", 43000);

        partidos = Arrays.asList(
                new Partido(grupoA.getEquipos().get(0), grupoA.getEquipos().get(1), estadio1, "2034-06-10", "10:00"),
                new Partido(grupoA.getEquipos().get(0), grupoA.getEquipos().get(2), estadio2, "2034-06-13", "14:00"),
                new Partido(grupoA.getEquipos().get(0), grupoA.getEquipos().get(3), estadio3, "2034-06-16", "18:00"),
                new Partido(grupoA.getEquipos().get(1), grupoA.getEquipos().get(2), estadio4, "2034-06-11", "10:00"),
                new Partido(grupoA.getEquipos().get(1), grupoA.getEquipos().get(3), estadio5, "2034-06-14", "12:00"),
                new Partido(grupoA.getEquipos().get(2), grupoA.getEquipos().get(3), estadio6, "2034-06-17", "14:00"),
                new Partido(grupoB.getEquipos().get(0), grupoB.getEquipos().get(1), estadio6, "2034-06-11", "16:00"),
                new Partido(grupoB.getEquipos().get(0), grupoB.getEquipos().get(2), estadio4, "2034-06-14", "15:00"),
                new Partido(grupoB.getEquipos().get(0), grupoB.getEquipos().get(3), estadio1, "2034-06-17", "17:00"),
                new Partido(grupoB.getEquipos().get(1), grupoB.getEquipos().get(2), estadio5, "2034-06-17", "10:00"),
                new Partido(grupoB.getEquipos().get(1), grupoB.getEquipos().get(3), estadio3, "2034-06-20", "14:00"),
                new Partido(grupoB.getEquipos().get(2), grupoB.getEquipos().get(3), estadio2, "2034-06-23", "12:00"),
                new Partido(grupoC.getEquipos().get(0), grupoC.getEquipos().get(1), estadio6, "2034-06-21", "16:00"),
                new Partido(grupoC.getEquipos().get(0), grupoC.getEquipos().get(2), estadio2, "2034-06-24", "12:00"),
                new Partido(grupoC.getEquipos().get(0), grupoC.getEquipos().get(3), estadio5, "2034-06-30", "14:00"),
                new Partido(grupoC.getEquipos().get(1), grupoC.getEquipos().get(2), estadio2, "2034-06-30", "10:00"),
                new Partido(grupoC.getEquipos().get(1), grupoC.getEquipos().get(3), estadio1, "2034-06-25", "12:00"),
                new Partido(grupoC.getEquipos().get(2), grupoC.getEquipos().get(3), estadio5, "2034-06-20", "15:00"),
                new Partido(grupoD.getEquipos().get(0), grupoD.getEquipos().get(1), estadio1, "2034-06-22", "18:00"),
                new Partido(grupoD.getEquipos().get(0), grupoD.getEquipos().get(2), estadio6, "2034-06-25", "09:00"),
                new Partido(grupoD.getEquipos().get(0), grupoD.getEquipos().get(3), estadio3, "2034-06-28", "15:00"),
                new Partido(grupoD.getEquipos().get(1), grupoD.getEquipos().get(2), estadio4, "2034-06-28", "19:00"),
                new Partido(grupoD.getEquipos().get(1), grupoD.getEquipos().get(3), estadio1, "2034-07-01", "10:00"),
                new Partido(grupoD.getEquipos().get(2), grupoD.getEquipos().get(3), estadio4, "2034-06-03", "15:00")
        );

        equipos = new ArrayList<>();
        for (Grupo grupo : grupos.values()) {
            equipos.addAll(grupo.getEquipos());
        }

        combo.removeAllItems();
        for (Equipo equipo : equipos) {
            combo.addItem(equipo.getNombre());
        }
        infoText.setText("Datos cargados.\n\n");
    }

    private void mostrarInfoEquipo() {
        String equipoNombre = (String) combo.getSelectedItem();
        Equipo equipo = equipos.stream()
                .filter(e -> e.getNombre().equals(equipoNombre))
                .findFirst()
                .orElse(null);
        if (equipo != null) {
            infoText.setText("Nombre del Equipo: " + equipo.getNombre() + "\n\n");
            infoText.append("Partidos:\n\n");
            for (Partido partido : partidos) {
                if (partido.getEquipoLocal().equals(equipo) || partido.getEquipoVisitante().equals(equipo)) {
                    infoText.append(partido.mostrarInfo() + "\n\n");
                }
            }
        }
    }

    private void mostrarPartidos() {
        infoText.setText("");
        for (Partido partido : partidos) {
            infoText.append(partido.mostrarInfo() + "\n");
            infoText.append("-".repeat(30) + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mundial().setVisible(true);
            }
        });
    }
}
