package pruebapractica;

public class Herramienta implements Runnable{

    String tipo;
    Boolean prestada;

    public Herramienta(String tipo) {
        this.tipo = tipo;
        this.prestada = false;
    }

    public String getTipo() {
        return tipo;
    }
    
    public Boolean Prestar() {
        this.prestada = true;
        return this.prestada;
    }
    
    public Boolean Devolver() {
        this.prestada = false;
        return this.prestada;
    }
    
    public Boolean isPrestada() {
        return prestada;
    }

    @Override
    public void run() {
        
    }
}