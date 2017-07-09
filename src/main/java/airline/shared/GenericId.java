package airline.shared;

import java.util.UUID;

public class GenericId {
    private String id;

    public GenericId() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
