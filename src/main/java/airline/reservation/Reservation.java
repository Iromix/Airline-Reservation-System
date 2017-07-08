package airline.reservation;

import java.util.Date;

class Reservation extends GenericId{
    private Date reservationDate;
    private Seat seat;
    private String clientId;

    public Reservation(Seat seat, String clientId) {
        this.clientId = clientId;
        this.seat = seat;
        reservationDate = new Date();
    }

    String getClientId() {
        return clientId;
    }
}
