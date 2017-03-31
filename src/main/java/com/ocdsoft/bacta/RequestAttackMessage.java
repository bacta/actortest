package com.ocdsoft.bacta;

import co.paralleluniverse.actors.ActorRef;
import lombok.Data;
import lombok.Getter;

/**
 * Created by kyle on 3/28/2017.
 */

@Data
public class RequestAttackMessage extends ServerObjectMessage {
    final ServerObjectType type = ServerObjectType.ATTACKMESSAGE;

    final ActorRef subject;
    final ActorRef target;
}
