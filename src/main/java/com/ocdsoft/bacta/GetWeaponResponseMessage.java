package com.ocdsoft.bacta;

import lombok.Data;

/**
 * Created by kyle on 3/31/2017.
 */
@Data
public class GetWeaponResponseMessage extends ServerObjectMessage {
    private final ServerObjectType type = ServerObjectType.GETWEAPON;
    private final String message;
}
