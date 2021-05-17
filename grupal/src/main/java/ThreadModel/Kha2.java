package ThreadModel;

public class Kha2 extends Thread {
    private String mensaje = "Soy Monkai";

    public Kha2(String mensaje) {
        this.mensaje = mensaje;
    }

    public void run() {
        String hilo = Thread.currentThread().getName();
        String hilos = String.format("Hola soy el hilo %s y %s", hilo, mensaje);
        System.out.println(hilos);
    }
}
