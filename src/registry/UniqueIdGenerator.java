package registry;

import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Luiz Oliveira on 2016-12-20.
 */
public class UniqueIdGenerator {

    private UUID uuid;

    public UUID getUuid() {
        this.uuid = UUID.randomUUID();
        return uuid;
    }

}
