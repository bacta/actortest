package com.ocdsoft.bacta;

import co.paralleluniverse.actors.ActorRef;
import co.paralleluniverse.actors.behaviors.Server;
import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;

/**
 * Hello world!
 *
 */
public class MmoServer
{
    public static void main( String[] args ) throws SuspendExecution, InterruptedException {

        ActorRef<ServerObjectMessage> subject = new ServerObjectActor("Kyle", "Sword of 1000 truths").spawn();
        ActorRef<ServerObjectMessage> target = new ServerObjectActor("cRush", "Sword of 100 truths").spawn();

        Server<ServerObjectMessage, CombatManagerActor.Result, ServerObjectMessage> combatManager = new CombatManagerActor("CombatManager").spawn();
        //Counter counter = (Counter) new ProxyServerActor(false, new CounterImpl()).spawn();

        new Fiber<Void>((SuspendableRunnable) () -> {
            combatManager.call(new RequestAttackMessage(subject, target));
            combatManager.cast(new ServerObjectMessage() {
                @Override
                public ServerObjectType getType() {
                    return ServerObjectType.GENERIC;
                }
            });
        }).start();

        new Fiber<Void>((SuspendableRunnable) () -> {
            combatManager.call(new RequestAttackMessage(target, subject));
            combatManager.cast(new ServerObjectMessage() {
                @Override
                public ServerObjectType getType() {
                    return ServerObjectType.GENERIC;
                }
            });
        }).start();
    }
}
