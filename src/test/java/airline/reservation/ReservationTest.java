package airline.reservation;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReservationTest {

    private static ReservationSystem reservationSystem;
    private static SeatRepository seatRepository;
    private static ReservationClient client;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        reservationSystem = new ReservationSystem();
        seatRepository = new HashmapSeatRepository();
        client = new ReservationClient();
    }

    @Test
    public void clientShouldAddReservation() {
        //given
        //todo create method to get free seat
        String seatId = "asdasd";

        //when
        reservationSystem.reserve(seatId, client.getId());

        //then
        List<Reservation> reservationsOfClient = reservationSystem.getReservationsByClient(client.getId());
        assertThat(reservationsOfClient.size(), equalTo(1));
    }

    @Test
    public void shouldNotReserveSeat_ThatIsAlreadyReserved() {
        //expected
        thrown.expect(ReservationException.class);
        thrown.expectMessage("Seat is already reserved");

        //given
        String seatId = seatRepository.findFirstFreeSeat().getId();
        reservationSystem.reserve(seatId, client.getId());

        //when
        reservationSystem.reserve(seatId, client.getId());
    }
}
