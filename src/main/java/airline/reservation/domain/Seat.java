package airline.reservation.domain;

import airline.shared.GenericId;

public class Seat extends GenericId {

    private SeatRate rate;
    private boolean reserved;

    public Seat(SeatRate rate) {
        this.rate = rate;
        reserved = false;
    }

    void reserve() {
        if (reserved)
            throw new RuntimeException("Seat is already reserved");
        reserved = true;
    }

    void releaseReservation() {
        reserved = false;
    }

    public boolean isReserved() {
        return reserved;
    }

    public SeatRate getRate() {
        return rate;
    }
}
