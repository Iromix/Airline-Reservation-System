package airline.reservation.domain;

import airline.shared.GenericId;

public class Reservation extends GenericId {
    //TODO remove seat and make "reserve" function
    private Seat seat;
    private String clientId;

    public Reservation(Seat seat, String clientId) {
        this.clientId = clientId;
        this.seat = seat;
    }

    public String getClientId() {
        return clientId;
    }
}
