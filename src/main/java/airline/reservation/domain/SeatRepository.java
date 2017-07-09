package airline.reservation.domain;

public interface SeatRepository {

    Seat findSeatById(String seatId);

    Seat findFirstFreeSeat();

    Seat findFirstFreeSeatWithRate(SeatRate seatRate);
}
