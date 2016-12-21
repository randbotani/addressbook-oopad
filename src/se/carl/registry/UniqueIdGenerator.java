package se.carl.registry;

import java.util.UUID;

class UniqueIdGenerator {

    public String generate() {
        UUID id = UUID.randomUUID();
        return id.toString();
    }
}
