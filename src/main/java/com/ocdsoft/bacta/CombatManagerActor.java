package com.ocdsoft.bacta;

import co.paralleluniverse.actors.ActorRef;
import co.paralleluniverse.actors.behaviors.RequestReplyHelper;
import co.paralleluniverse.actors.behaviors.ServerActor;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.Strand;

/**
 * Created by kyle on 3/28/2017.
 */

public class CombatManagerActor extends ServerActor<ServerObjectMessage, CombatManagerActor.Result, ServerObjectMessage> {

    public CombatManagerActor(String name) {
        super(name);
    }

    public enum Result {SUCCESS, FAILURE}

    @Override
    protected CombatManagerActor.Result handleCall(ActorRef<?> from, Object id, ServerObjectMessage message) throws Exception, SuspendExecution {

        switch(message.getType()) {
            case ATTACKMESSAGE:
                return handleAttack(from, id, (RequestAttackMessage) message);
            default:
                return Result.FAILURE;
        }


    }

    @Override
    protected void handleCast(ActorRef<?> from, Object id, ServerObjectMessage message) throws SuspendExecution {
        try {
            Strand.sleep(500);
        } catch (InterruptedException e) {
            log().error("", e);
        }
        log().info("Received cast message: " + message.getType());
    }

    private CombatManagerActor.Result handleAttack(ActorRef<?> from, Object id, RequestAttackMessage message) throws SuspendExecution, InterruptedException {
        ActorRef<ServerObjectMessage> subject = message.getSubject();
        ActorRef target = message.getTarget();

        GetWeaponResponseMessage subjectWeapon = (GetWeaponResponseMessage) RequestReplyHelper.call(subject, new GetWeaponRequestMessage());

        log().info(subject.getName() + " attacks " + target.getName() + " with " + subjectWeapon.getMessage());
        return Result.SUCCESS;
    }
}