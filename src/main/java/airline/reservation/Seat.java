package airline.reservation;

class Seat extends GenericId{
    private boolean reserved;

    Seat() {
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
}
