package airline.reservation;

interface SeatRepository {

    Seat findSeatById(String seatId);

    Seat findFirstFreeSeat();

    Seat findFirstFreeSeatWithRate(SeatRate seatRate);
}
