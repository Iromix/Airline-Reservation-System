package airline.reservation;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ReservationTest {

    private static ReservationSystem reservationSystem;

    @BeforeClass
    public static void setUp() {
        reservationSystem = new ReservationSystem();
    }

    @Test
    public void clientShouldAddReservation() {
        //given
        ReservationClient client = new ReservationClient();
        long seatId = 1L;

        //when
        reservationSystem.reserve(seatId, client.getId());

        //then
        List<Reservation> reservationsOfClient = reservationSystem.getReservationsByClient(client.getId());
        assertThat(reservationsOfClient.size(), equalTo(1));
    }

    @Test
    @Ignore
    public void shouldNotAddAlreadyBookedReservation() {
        fail();
    }
}
