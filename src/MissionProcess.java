import Utils.MissionUtils;

public class MissionProcess {

    // Método principal del subproceso de misión En el que se revisa el éxito o fracaso de la misión de los muchachines
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Uso: MissionProcess <nombre> <dificultad> <integrantes>");
            return;
        }

        // Parámetros de entrada del subproceso uwu

        String nombre = args[0];
        int dificultad = Integer.parseInt(args[1]);
        String[] integrantes = args[2].split(",");

        // Calcular poder total y química como si fuese un futdraft del fifa (Te hacen falta mas videos del DJMaRiiO)
        int poderTotal = MissionUtils.calcularPoderEquipo(integrantes); // --> Aun no tenemos MissionUtils, pero cuando lo tengamos funcará
        String quimica = MissionUtils.calcularQuimica(integrantes); // --> Aun no tenemos MissionUtils, pero cuando lo tengamos funcará

        String resultado = (poderTotal >= dificultad * 40) ? "¡Eureca!" : "Fracaso estrepitoso, malísimos, expulsados del reino de una patada";

        // Salida del subproceso uwu
        System.out.println("Misión: " + nombre);
        System.out.println("Integrantes: " + String.join(", ", integrantes));
        System.out.println("Dificultad: " + dificultad);
        System.out.println("Poder combinado: " + poderTotal);
        System.out.println("Química del equipo: " + quimica);
        System.out.println("Resultado: " + resultado);
    }
}
