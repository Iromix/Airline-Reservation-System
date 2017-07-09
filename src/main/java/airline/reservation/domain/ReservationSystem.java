package airline.reservation.domain;

import airline.reservation.infrastracture.HashmapReservationRepository;
import airline.reservation.infrastracture.HashmapSeatRepository;

import java.util.List;

public class ReservationSystem {

    private ReservationRepository reservationRepository;
    private SeatRepository seatRepository;

    public ReservationSystem() {
        this.reservationRepository = new HashmapReservationRepository();
        this.seatRepository = new HashmapSeatRepository();
    }

    public void reserve(SeatRate seatRate, String clientId) {
        Seat seat = seatRepository.findFirstFreeSeatWithRate(seatRate);
        if (seat == null)
            throw new ReservationException("There is no seat left with rate " + seatRate);

        reserve(seat.getId(), clientId);
    }

    public void reserve(String seatId, String clientId) {
        //TODO check business logic
        Seat seat = seatRepository.findSeatById(seatId);
        if (seat == null)
            throw new ReservationException("Can't find such seat");

        if (seat.isReserved())
            throw new ReservationException("Seat is already reserved");
        Reservation reservation = new Reservation(seat, clientId);

        seat.reserve();
        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByClient(String clientId) {
        return reservationRepository.findReservationsByClientId(clientId);
    }
}
