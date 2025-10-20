import java.io.*;
import java.util.*;

public class MainProcess {

    // Con esto se ejecutan los subprocesos para cada misión y se recopilan los resultados. uwu
    public static void main(String[] args) {
        List<Process> procesos = new ArrayList<>();
        List<File> resultados = new ArrayList<>();

        // Leer archivo de misiones y crear subprocesos. No se me ocurre más 

        try (BufferedReader br = new BufferedReader(new FileReader("data/misiones.txt"))) {
            String linea;
            int contador = 1;

            while ((linea = br.readLine()) != null) {
                // Aqui nombra los datos de la misión separados por ; Y pongo datos[0], datos[1], datos[2] para cada campo. Lo que se me ocurrió xD
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String dificultad = datos[1];
                String integrantes = datos[2];

                // Archivo de salida, sin más
                File outFile = new File("results/resultado_mision" + contador + ".txt");
                resultados.add(outFile);

                // Creamos ahora si que si los subprocesos
                ProcessBuilder pb = new ProcessBuilder(
                        "java", "MissionProcess", nombre, dificultad, integrantes
                );
                pb.redirectOutput(outFile);
                pb.redirectError(ProcessBuilder.Redirect.INHERIT);

                Process p = pb.start();
                procesos.add(p);
                contador++;
            }

            // Esperamos a que termine todo todito
            for (Process p : procesos) {
                p.waitFor();
            }

            // Muestra un informe final con todos los resultados juntitos uwu
            System.out.println("===== INFORME DE MISIONES (Inspirado en el focking besto shonen bitch) =====");
            for (File f : resultados) {
                try (BufferedReader brOut = new BufferedReader(new FileReader(f))) {
                    brOut.lines().forEach(System.out::println);
                }
                System.out.println("----------------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}