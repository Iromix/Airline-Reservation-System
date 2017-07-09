package airline.reservation;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

//TODO add more scenario and then add more DDD structure
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
    public void clientShouldAddReservation_WithSpecificSeat() {
        //given
        ReservationClient newClient = new ReservationClient();
        String seatId = seatRepository.findFirstFreeSeat().getId();

        //when
        reservationSystem.reserve(seatId, newClient.getId());

        //then
        List<Reservation> reservationsOfClient = reservationSystem.getReservationsByClient(newClient.getId());
        assertThat(reservationsOfClient.size(), equalTo(1));
    }

    @Test
    public void clientShouldAddReservation_WithChoosedClassSeat() {
        //given
        ReservationClient newClient = new ReservationClient();

        //when
        reservationSystem.reserve(SeatRate.FIRST_CLASS, newClient.getId());

        //then
        List<Reservation> reservationsOfClient = reservationSystem.getReservationsByClient(newClient.getId());
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
