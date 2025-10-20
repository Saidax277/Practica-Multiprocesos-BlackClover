package Utils;

import java.util.*;
import java.util.stream.Collectors;
import Wizard;

public class MissionUtils {

    // Base de datos simulada de magos disponibles (Fueron los que se me ocurrieron xD)
    private static final Map<String, Wizard> WIZARDS = new HashMap<>();
    static {
        WIZARDS.put("Asta", new Wizard("Asta", 120, "Anti-magia"));
        WIZARDS.put("Yuno", new Wizard("Yuno", 150, "Viento"));
        WIZARDS.put("Noelle", new Wizard("Noelle", 110, "Agua"));
        WIZARDS.put("Mimosa", new Wizard("Mimosa", 100, "Planta"));
        WIZARDS.put("Luck", new Wizard("Luck", 130, "Rayo"));
        WIZARDS.put("Magna", new Wizard("Magna", 90, "Fuego"));
        WIZARDS.put("Charmy", new Wizard("Charmy", 80, "Algodón"));
    }

    // Calcula el poder total del equipo sumando los poderes base de cada mago, poniendo 50 si no se encuentra al mago

    public static int calcularPoderEquipo(String[] integrantes) {
        return Arrays.stream(integrantes)
                .map(String::trim)
                .mapToInt(nombre -> WIZARDS.getOrDefault(nombre, new Wizard(nombre, 50, "Desconocido")).getPoderBase())
                .sum();
    }

    // Calcula la química del equipo basándose en las afinidades mágicas de los magos, pone 50 si no se encuentra al mago

    public static String calcularQuimica(String[] integrantes) {
        List<String> afinidades = Arrays.stream(integrantes)
                .map(String::trim)
                .map(nombre -> WIZARDS.getOrDefault(nombre, new Wizard(nombre, 50, "Desconocido")).getAfinidad())
                .collect(Collectors.toList());

                // Reglas simples para determinar la química del equipo (Se me ocurrieron estas xD)

        if (afinidades.contains("Agua") && afinidades.contains("Planta")) {
            return "Sinergia natural, obviamente el agua y planta combinan bien";
        } else if (afinidades.contains("Fuego") && afinidades.contains("Viento")) {
            return "Combustión explosiva, el fuego y viento crean un torbellino de fuego a lo Axel Blaze";
        } else if (afinidades.contains("Anti-magia")) {
            return "Anti-magia está chetada";
        }
        return "Química neutra";
    }
}