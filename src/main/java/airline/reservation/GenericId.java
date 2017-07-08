package airline.reservation;

import java.util.UUID;

class GenericId {
    private String id;

    GenericId() {
        id = UUID.randomUUID().toString();
    }

    String getId() {
        return id;
    }
}
