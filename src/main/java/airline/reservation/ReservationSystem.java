package airline.reservation;

import java.util.List;

class ReservationSystem {

    private ReservationRepository reservationRepository;
    private SeatRepository seatRepository;

    ReservationSystem() {
        this.reservationRepository = new HashmapReservationRepository();
        this.seatRepository = new SeatRepository();
    }

    void reserve(long seatId, String clientId) {
        //TODO check business logic
        Seat seat = seatRepository.getSeat(seatId);
        if (seat == null)
            throw new ReservationException("Can't find such seat");

        if (seat.isReserved())
            throw new ReservationException("Seat is already reserved");

        seat.reserve();
        Reservation reservation = new Reservation(seat, clientId);
        reservationRepository.save(reservation);
    }

    List<Reservation> getReservationsByClient(String clientId) {
        return reservationRepository.findReservationsByClientId(clientId);
    }
}
