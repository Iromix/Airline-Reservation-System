package airline.reservation;

import airline.reservation.domain.*;
import airline.reservation.infrastracture.HashmapSeatRepository;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReservationTest {

    private static ReservationSystem reservationSystem;
    private static SeatRepository seatRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        reservationSystem = new ReservationSystem();
        seatRepository = new HashmapSeatRepository();
    }

    @Test
    public void clientShouldAddReservation_WithSpecificSeat() {
        //given
        String newClientId = getRandomClientId();
        String seatId = seatRepository.findFirstFreeSeat().getId();

        //when
        reservationSystem.reserve(seatId, newClientId);

        //then
        List<Reservation> reservationsOfClient = reservationSystem.getReservationsByClient(newClientId);
        assertThat(reservationsOfClient.size(), equalTo(1));
    }

    @Test
    public void clientShouldAddReservation_WithChoosedClassSeat() {
        //given
        String newClientId = getRandomClientId();

        //when
        reservationSystem.reserve(SeatRate.FIRST_CLASS, newClientId);

        //then
        List<Reservation> reservationsOfClient = reservationSystem.getReservationsByClient(newClientId);
        assertThat(reservationsOfClient.size(), equalTo(1));
    }

    private String getRandomClientId() {
        return UUID.randomUUID().toString();
    }

    @Test
    public void shouldNotReserveSeat_ThatIsAlreadyReserved() {
        //expected
        thrown.expect(ReservationException.class);
        thrown.expectMessage("Seat is already reserved");

        //given
        String newClientId = getRandomClientId();
        String seatId = seatRepository.findFirstFreeSeat().getId();
        reservationSystem.reserve(seatId, newClientId);

        //when
        reservationSystem.reserve(seatId, newClientId);
    }
}
