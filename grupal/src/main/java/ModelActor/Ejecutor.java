package ModelActor;
import akka.actor.typed.ActorSystem;

import java.io.IOException;


public class Ejecutor {
    public static void main(String[] args) {
        // Actor del System
        ActorSystem<Actor1.Command> mySystem = ActorSystem.create(Actor1.create(), "Hello");
        ActorSystem<Actor2.Command> mySystems = ActorSystem.create(Actor2.create(), "Hello");

        mySystem.tell(Actor1.SayHello.Instance);
        mySystems.tell(Actor2.SayHello.Instance);
        mySystem.tell(new Actor1.ChangeMessage("Soy Monkai"));
        mySystems.tell(new Actor2.ChangeMessage("Soy Steve"));
        mySystem.tell(Actor1.SayHello.Instance);
        mySystems.tell(Actor2.SayHello.Instance);

        // Para finalizar el programa de actores
        try {
            System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ignored) {
        } finally {
            mySystem.terminate();
            mySystems.terminate();
        }
    }
}
