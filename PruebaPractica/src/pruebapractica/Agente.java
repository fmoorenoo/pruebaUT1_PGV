package pruebapractica;


public class Agente implements Runnable {
    private String nombre;
    private Actividad actividad;

    public Agente(String nombre, Actividad actividad) {
        this.nombre = nombre;
        this.actividad = actividad;
    }

    @Override
    public void run() {
        System.out.printf("El agente %s quiere hacer la actividad %s.\n", 
                this.nombre, actividad.id);
        if (actividad.activa) {
            try {
                this.wait();
                System.out.printf("El agente %s debe esperar.\n", this.nombre);
            } catch (InterruptedException ex) {
              
            }
        } else {
            actividad.iniciar();
        }
    }
}
