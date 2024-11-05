package pruebapractica;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad implements Runnable {

    String id;
    Herramienta h1;
    Herramienta h2;
    Herramienta h3;
    Boolean activa;
    Random random;

    public Actividad(String id, Herramienta h1, Herramienta h2, Herramienta h3) {
        this.id = id;
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.activa = false;
    }

    public String getId() {
        return id;
    }

    public Herramienta getH1() {
        return h1;
    }

    public Herramienta getH2() {
        return h2;
    }

    public Herramienta getH3() {
        return h3;
    }
    
    public void iniciar() {
        this.activa = true;
        this.run();
    }
    
    public void finalizar() {
        this.activa = false;
    }

    @Override
    public void run() {
        if (h1.isPrestada() || h2.isPrestada() || h3.isPrestada()) {
            try {
                // Si alguna de las herramientas está siendo usada, espera.
                this.wait();
            } catch (InterruptedException ex) {
            }
        } else {
            h1.Prestar();
            h2.Prestar();
            h3.Prestar();
            int duracion = 50 + random.nextInt(200 - 50 + 1);
            System.out.printf("Actividad %s usa las herramientas %s, %s y %s durante %d ms. \n",
                    this.id, this.h1, this.h2, this.h3, duracion);
            try {
                // Duración de la actividad
                Thread.sleep(duracion);
                h1.Devolver();
                h2.Devolver();
                h3.Devolver();
                
            System.out.printf("Actividad %s termina y se devuelven las herramientas %s, %s y %s. \n",
                    this.id, this.h1, this.h2, this.h3);
            
                // Avisa a los demás hilos de que ya acabó de usar las herramientas
                this.notifyAll();
            } catch (InterruptedException ex) {
            }
        }
    }
}
