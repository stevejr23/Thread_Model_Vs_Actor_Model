package ModelActor;

// Importaciones de librerias para crear actores

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class Actor1 extends AbstractBehavior<Actor1.Command> {

    interface Command {
    }

    // Actor padre
    public enum SayHello implements Command {
        Instance
    }

    private String message = "Hola soy Fabian";

    // Cambio de mensaje
    public static class ChangeMessage implements Command {
        public final String newMessage;

        public ChangeMessage(String newMessage) {
            this.newMessage = newMessage;
        }
    }

    // Presentar los mensajes que tienen los actores principal
    public static Behavior<Command> create() {

        return Behaviors.setup(context -> new Actor1(context));
    }

    // Presentar los mensajes que tienen los actores secundarios
    private Actor1(ActorContext<Command> context) {
        super(context);
    }

    // Asignar los nombres
    @Override
    public Receive<Actor1.Command> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals(SayHello.Instance, this::onSayHello)
                .onMessage(ChangeMessage.class, this::onChangeMessage)
                .build();
    }

    // Remplazar el mensaje actual con el nuevo mensaje
    private Behavior<Command> onChangeMessage(ChangeMessage command) {
        message = command.newMessage;
        return this;
    }

    // Imprimir el mensaje actual
    private Behavior<Command> onSayHello() {
        System.out.println(message);
        return this;
    }
}
