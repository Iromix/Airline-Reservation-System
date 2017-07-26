package airline.reservation.domain;

public class ReservationException extends RuntimeException {
    ReservationException(String message) {
        super(message);
    }
}
