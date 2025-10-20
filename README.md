En el Reino del Trébol, el Rey Mago necesita estar informado en todo momento sobre el estado de las misiones que realizan los distintos escuadrones de caballeros mágicos.
La gestión manual de estas tareas resulta lenta y propensa a errores, por lo que se requiere una aplicación multiproceso que permita:
- Registrar varias misiones en paralelo.
- Asignar a cada misión un grupo de caballeros mágicos con sus poderes y afinidades.
- Procesar la información de cada misión de forma independiente (subprocesos).
- Consolidar los resultados en un informe global para que el Rey Mago pueda tomar decisiones rápidas y estratégicas.
De esta forma, la aplicación simula una necesidad empresarial real: coordinar múltiples tareas simultáneamente, optimizando recursos y tiempos de respuesta.

⚙️ Funcionamiento de la aplicación
1. Entrada de datos
- El programa principal (MainProcess) lee un fichero de texto (data/misiones.txt) con las misiones asignadas.
- Cada línea del fichero contiene:
NombreMision;Dificultad;Integrantes


- Ejemplo:
Derrotar bandidos;5;Asta,Yuno
Proteger al pueblo;7;Noelle,Mimosa
2. Creación de subprocesos- Por cada misión, el proceso principal lanza un subproceso (MissionProcess).
- Cada subproceso recibe los datos de la misión como argumentos y calcula:
- Poder combinado del equipo.
- Química entre los integrantes.
- Resultado de la misión (éxito o fracaso).
3. Redirección de resultados- La salida de cada subproceso se redirige automáticamente a un fichero en la carpeta results/.
- Ejemplo:
results/resultado_mision1.txt
results/resultado_mision2.txt
4. Informe global- Una vez terminan todos los subprocesos, el proceso principal recopila los resultados y muestra en consola un informe consolidado con todas las misiones.
🖥️ Manual de usuario (con capturas)- Clonar o descargar el proyecto.
- Asegurarse de tener Java 21 instalado.
- Colocar las misiones en el archivo data/misiones.txt.
- Compilar el proyecto:
javac -d bin src/*.java src/utils/*.java


- Ejecutar el proceso principal:
java -cp bin MainProcess


- Revisar los resultados:
- En consola aparecerá el informe global.
- En la carpeta results/ estarán los informes individuales de cada misión.

<img width="668" height="118" alt="Captura de pantalla 2025-10-20 175756" src="https://github.com/user-attachments/assets/1cd4f024-346b-4f09-bdb9-3c7cf9f1f8f0" />


