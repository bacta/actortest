package com.ocdsoft.bacta;

import co.paralleluniverse.actors.ActorRef;
import lombok.Data;

/**
 * Created by kyle on 3/28/2017.
 */

@Data
public class NotificationMessage implements ServerAsyncMessage {
    final String message;
}
