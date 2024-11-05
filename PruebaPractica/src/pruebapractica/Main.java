package pruebapractica;

// Crea el objeto compartido
// Crea hilos en un bucle, y los lanza
public class Main {

    // Constantes
    public static int NUMERO_AGENTES = 4;
    public static int NUMERO_HERRAMIENTAS = 3;
    public static int NUMERO_ACTIVIDADES = 3;

    public static void main(String[] args) {
        // Crear las herramientas
        Herramienta herramientas[] = new Herramienta[NUMERO_HERRAMIENTAS];
        herramientas[0] = new Herramienta("taladro");
        herramientas[1] = new Herramienta("destornillador");
        herramientas[2] = new Herramienta("alicates");

        // Crear tres actividades con sus herramientas
        Actividad actividades[] = new Actividad[NUMERO_ACTIVIDADES];
        actividades[0] = new Actividad("A1", herramientas[0], herramientas[1], null);
        actividades[1] = new Actividad("A2", herramientas[1], herramientas[2], null);
        actividades[2] = new Actividad("A1", herramientas[0], herramientas[1], herramientas[2]);
       
        // Crear los agentes con su actividad
        Thread agentes[] = new Thread[NUMERO_AGENTES];
        agentes[0] = new Thread(new Agente("Fer", actividades[0]));
        agentes[1] = new Thread(new Agente("Fabio", actividades[0]));
        agentes[2] = new Thread(new Agente("Iriem", actividades[1]));
        agentes[3] = new Thread(new Agente("Unai", actividades[2]));

        // Lanzar los Agentes
        for (Thread agente : agentes) {
            agente.start();
        }

        // Esperar a que todos los agentes terminen
        for (Thread agente : agentes) {
            try {
                agente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
