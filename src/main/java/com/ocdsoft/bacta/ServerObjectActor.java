package com.ocdsoft.bacta;

import co.paralleluniverse.actors.BasicActor;
import co.paralleluniverse.actors.behaviors.RequestReplyHelper;
import co.paralleluniverse.fibers.SuspendExecution;

/**
 * Created by kyle on 3/28/2017.
 */
public class ServerObjectActor extends BasicActor<ServerObjectMessage, Void> {

    private final String weapon;

    public ServerObjectActor(String name, String weapon) {
        super(name);
        this.weapon = weapon;
    }

    protected Void doRun() throws InterruptedException, SuspendExecution {
        for(;;) {
            ServerObjectMessage msg = receive();

            if(msg instanceof GetWeaponRequestMessage) {
                RequestReplyHelper.reply(msg, new GetWeaponResponseMessage(weapon));
            }
        }
    }
}
