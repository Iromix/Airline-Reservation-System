package airline.reservation;

import java.util.UUID;

class ReservationClient {
    private String clientId;

    ReservationClient() {
        clientId = UUID.randomUUID().toString();
    }

    String getId() {
        return clientId;
    }
}
