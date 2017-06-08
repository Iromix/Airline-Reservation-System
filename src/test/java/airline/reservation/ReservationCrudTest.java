package airline.reservation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReservationCrudTest {

    @Test
    public void shouldAddReservation() {
        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.book(12, 23);

        assertThat(bookingSystem.getReservations().size(), equalTo(1));
    }

    @Test
    public void shouldNotAddAlreadyBookedReservation() {

    }
}
