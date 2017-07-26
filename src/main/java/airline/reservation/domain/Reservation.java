package airline.reservation.domain;

import airline.shared.GenericId;

public class Reservation extends GenericId {
    private String seatId;
    private String clientId;

    public Reservation(String seatId, String clientId) {
        this.clientId = clientId;
        this.seatId = seatId;
    }

    public String getClientId() {
        return clientId;
    }
}
