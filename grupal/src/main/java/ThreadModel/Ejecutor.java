package ThreadModel;

public class Ejecutor {
    public static void main(String[] args) throws InterruptedException{
        Mi1 Khal = new Mi1("LOL");
        Kha2 lifa = new Kha2("Valorant");

        for (int i = 0; i < 3; i++) {
            Thread hilo = new Thread(Khal, String.valueOf(i));
            hilo.start();
            hilo.join();
        }
        for (int i = 0; i < 3; i++) {
            Thread hilo = new Thread(lifa, String.valueOf(i));
            hilo.start();
            hilo.join();
        }
    }
}
