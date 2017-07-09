package airline.reservation.domain;

import java.util.List;

public interface ReservationRepository {

    void save(Reservation reservation);

    Reservation findById(String reservationId);

    int countReservations();

    void delete(String reservationId);

    void update(String reservationId, Reservation newReservation);

    List<Reservation> findReservationsByClientId(String clientId);
}
