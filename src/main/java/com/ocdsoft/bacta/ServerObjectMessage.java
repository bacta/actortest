package com.ocdsoft.bacta;

import co.paralleluniverse.actors.behaviors.RequestMessage;
import lombok.Data;

/**
 * Created by kyle on 3/28/2017.
 */

@Data
public abstract class ServerObjectMessage extends RequestMessage<ServerObjectMessage> {
    public abstract ServerObjectType getType();
}
