package se.carl.registry;

import java.util.UUID;
import java.util.logging.Logger;

class UniqueIdGenerator {
    private static final Logger log = Logger.getLogger(UniqueIdGenerator.class.getName());

    public UUID generate() {
        log.info("Generating a unique id (UUID).");
        UUID id = UUID.randomUUID();
        return id;
    }
}
