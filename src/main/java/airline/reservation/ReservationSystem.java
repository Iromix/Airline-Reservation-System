package airline.reservation;

import java.util.List;

class ReservationSystem {

    private ReservationRepository reservationRepository;
    private SeatRepository seatRepository;

    ReservationSystem() {
        this.reservationRepository = new HashmapReservationRepository();
        this.seatRepository = new HashmapSeatRepository();
    }

    void reserve(SeatRate seatRate, String clientId) {
        Seat seat = seatRepository.findFirstFreeSeatWithRate(seatRate);
        if (seat == null)
            throw new ReservationException("There is no seat left with rate " + seatRate);

        reserve(seat.getId(), clientId);
    }

    void reserve(String seatId, String clientId) {
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

    List<Reservation> getReservationsByClient(String clientId) {
        return reservationRepository.findReservationsByClientId(clientId);
    }
}
