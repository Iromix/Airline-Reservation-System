package airline.reservation.domain;

import airline.reservation.infrastracture.HashmapReservationRepository;
import airline.reservation.infrastracture.HashmapSeatRepository;

import java.util.List;

public class ReservationSystem {

    private ReservationRepository reservationRepository;
    private SeatRepository seatRepository;
    private SeatService seatService;

    public ReservationSystem(SeatService seatService) {
        this.seatService = seatService;
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
        Seat seat = seatRepository.findSeatById(seatId);
        if (seat == null)
            throw new ReservationException("Can't find such seat");

        Reservation reservation = new Reservation(seatId, clientId);
        reservationRepository.save(reservation);
        seatService.reserve(seat);
    }

    public List<Reservation> getReservationsByClient(String clientId) {
        return reservationRepository.findReservationsByClientId(clientId);
    }
}
