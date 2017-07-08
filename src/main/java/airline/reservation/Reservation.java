package airline.reservation;

import java.util.Date;
import java.util.UUID;

class Reservation {
    private String id;
    private Date reservationDate;
    private Seat seat;
    private String clientId;

    public Reservation(Seat seat, String clientId) {
        id = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.seat = seat;
        reservationDate = new Date();
    }

    String getId() {
        return id;
    }

    String getClientId() {
        return clientId;
    }
}
