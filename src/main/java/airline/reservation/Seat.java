package airline.reservation;

class Seat extends GenericId{

    private SeatRate rate;
    private boolean reserved;

    Seat(SeatRate rate) {
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

    boolean isReserved() {
        return reserved;
    }

    SeatRate getRate() {
        return rate;
    }
}
