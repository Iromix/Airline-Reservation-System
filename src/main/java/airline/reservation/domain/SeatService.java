package airline.reservation.domain;

public class SeatService {
    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    void reserve(Seat seat) {
        seat.reserve();
        seatRepository.update(seat);
    }

    public Seat findFirstFreeSeat() {
        return seatRepository.findFirstFreeSeat();
    }
}

