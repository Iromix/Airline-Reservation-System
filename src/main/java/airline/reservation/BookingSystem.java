package airline.reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BookingSystem {

    private List<Reservation> reservations = new ArrayList<Reservation>();

    private ReservationRepository reservationRepository;

    void book(Integer seatNumber, Integer flyightId) {

    }

    List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
}
