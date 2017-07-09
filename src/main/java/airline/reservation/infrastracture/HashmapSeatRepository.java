package airline.reservation.infrastracture;

import airline.reservation.domain.Seat;
import airline.reservation.domain.SeatRate;
import airline.reservation.domain.SeatRepository;

import java.util.HashMap;
import java.util.Map;

public class HashmapSeatRepository implements SeatRepository {

    private static final Map<String, Seat> seats = new HashMap<>();

    static {
        initSeats();
    }

    private static void initSeats() {
        addSeats(100, SeatRate.FIRST_CLASS);
        addSeats(100, SeatRate.STANDARD);
        addSeats(100, SeatRate.POOR);
    }

    private static void addSeats(int numberOfSeats, SeatRate seatRate) {
        Seat seat;
        for (int i = 0; i< numberOfSeats; i++) {
            seat = new Seat(seatRate);
            seats.put(seat.getId(), seat);
        }
    }

    @Override
    public Seat findSeatById(String seatId) {
        if (!seats.containsKey(seatId))
            return null;
        return seats.get(seatId);
    }

    @Override
    public Seat findFirstFreeSeat() {
        for (Map.Entry<String, Seat> seatEntry : seats.entrySet()) {
            Seat seat = seatEntry.getValue();
            if (!seat.isReserved())
                return seat;
        }
        return null;
    }

    @Override
    public Seat findFirstFreeSeatWithRate(SeatRate seatRate) {
        for (Map.Entry<String, Seat> seatEntry : seats.entrySet()) {
            Seat seat = seatEntry.getValue();
            if (!seat.isReserved() && seat.getRate() == seatRate)
                return seat;
        }
        return null;
    }
}
