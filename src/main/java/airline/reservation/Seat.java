package airline.reservation;

import java.util.UUID;

class Seat {
    private String seatId;
    private boolean reserved;

    Seat() {
        seatId = UUID.randomUUID().toString();
        reserved = false;
    }

    public String getSeatId() {
        return seatId;
    }

    void reserve() {
        if (reserved)
            throw new RuntimeException("Seat is already reserved");
        reserved = true;
    }

    void releaseReservation() {
        reserved = false;
    }

    boolean isReserved() {
        return reserved;
    }
}
