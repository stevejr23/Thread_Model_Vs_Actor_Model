package ThreadModel;

public class Ejecutor {
    public static void main(String[] args) {
        Hilo1 Mi1 = new Hilo1();
        Hilo2 Kha2 = new Hilo2();

        for (int i = 0; i < 3; i++) {
           // Thread hilo = new Thread(Mi1, String.valueOf(i));
            hilo.start();
            if (i== 1)

        }
    }
}
