package airline.reservation;

import java.util.HashMap;
import java.util.Map;

class HashmapSeatRepository implements SeatRepository {

    private static final Map<String, Seat> seats = new HashMap<>();

    static {
        initSeats();
    }

    private static void initSeats() {
        Seat seat1 = new Seat();
        Seat seat2 = new Seat();
        Seat seat3 = new Seat();
        seats.put(seat1.getId(), seat1);
        seats.put(seat2.getId(), seat2);
        seats.put(seat3.getId(), seat2);
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
}
