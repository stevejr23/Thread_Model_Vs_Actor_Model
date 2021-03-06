package ModelActor;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class Actor2 extends AbstractBehavior<Actor2.Command> {

    interface Command {
    }

    public enum SayHello implements Command {
        Instance
    }

    public static class ChangeMessage implements Command {
        public final String newMessage;

        public ChangeMessage(String newMessage) {
            this.newMessage = newMessage;
        }
    }

    public static Behavior<Command> create() {
        return Behaviors.setup(context -> new Actor2(context));
    }

    private String message = "Hola soy Steven";

    private Actor2(ActorContext<Command> context) {
        super(context);
    }

    @Override
    public Receive<Actor2.Command> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals(SayHello.Instance, this::onSayHello)
                .onMessage(ChangeMessage.class, this::onChangeMessage)
                .build();
    }

    private Behavior<Command> onChangeMessage(ChangeMessage command) {
        message = command.newMessage;
        return this;
    }

    private Behavior<Command> onSayHello() {
        System.out.println(message);
        return this;
    }
}