package airline.reservation.infrastracture;

import airline.reservation.domain.Reservation;
import airline.reservation.domain.ReservationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashmapReservationRepository implements ReservationRepository {

    private static final Map<String, Reservation> reservations = new HashMap<>();

    @Override
    public void save(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    @Override
    public Reservation findById(String reservationId) {
        if (!reservations.containsKey(reservationId))
            return null;
        return reservations.get(reservationId);
    }

    @Override
    public int countReservations() {
        return reservations.size();
    }

    @Override
    public void delete(String reservationId) {
        reservations.remove(reservationId);
    }

    @Override
    public void update(String reservationId, Reservation newReservation) {
        reservations.put(reservationId, newReservation);
    }

    @Override
    public List<Reservation> findReservationsByClientId(final String clientId) {
        return reservations.entrySet()
            .stream()
            .filter(map -> map.getValue().getClientId().equals(clientId))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
    }
}
